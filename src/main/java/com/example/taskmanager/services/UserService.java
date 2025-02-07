package com.example.taskmanager.services;

import com.example.taskmanager.common.response.ResponseWrapper;
import com.example.taskmanager.config.SystemConfig;
import com.example.taskmanager.config.SystemMessages;
import com.example.taskmanager.dto.user.createuser.CreateNewUserRequest;
import com.example.taskmanager.dto.user.createuser.CreateNewUserResponse;
import com.example.taskmanager.dto.user.deleteuser.DeleteUserRequest;
import com.example.taskmanager.dto.user.deleteuser.DeleteUserResponse;
import com.example.taskmanager.dto.user.getusers.GetUser;
import com.example.taskmanager.dto.user.getusers.GetUsersResponse;
import com.example.taskmanager.dto.user.updateuser.UpdateUserRequest;
import com.example.taskmanager.dto.user.updateuser.UpdateUserResponse;
import com.example.taskmanager.entities.User;
import com.example.taskmanager.enums.UserStatusEnum;
import com.example.taskmanager.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository usersRepository;

    public ResponseWrapper<CreateNewUserResponse> createNewUser(
            final CreateNewUserRequest newUser) {

        log.info("Creating new user");

        User user = User.builder()
                .name(newUser.getName())
                .username(newUser.getUsername())
                .email(newUser.getEmail())
                .password(newUser.getPassword())
                .department(newUser.getDepartment())
                .userStatus(UserStatusEnum.ACTIVE.getCode())
                .build();
        try {

            user = usersRepository.save(user);

        } catch (DataIntegrityViolationException e) {
            return ResponseWrapper.<CreateNewUserResponse>builder()
                    .status(HttpStatus.BAD_REQUEST.value())
                    .message(SystemMessages.USERNAME_ALREADY_EXIST)
                    .build();
        }

        final CreateNewUserResponse createNewUserResponse = CreateNewUserResponse.builder()
                .name(user.getName())
                .email(user.getEmail())
                .username(user.getUsername())
                .department(user.getDepartment())
                .build();

        return ResponseWrapper.<CreateNewUserResponse>builder()
                .status(HttpStatus.OK.value())
                .message(SystemMessages.GET_ALL_USERS)
                .data(createNewUserResponse)
                .build();
    }

    public ResponseWrapper<GetUsersResponse> getUsersList(
            final Integer pageNumber,
            final Integer pageSize) {

        log.info("Fetching Users . . .");

        Pageable pageable = PageRequest.of(pageNumber,
                pageSize,
                Sort.by(Sort.Direction.DESC,
                        SystemConfig.DEFAULT_SORTING));

        GetUsersResponse data = GetUsersResponse.builder()
                .users(GetUsersResponse.mapper(usersRepository.getUsersList(pageable)))
                .build();

        return ResponseWrapper.<GetUsersResponse>builder()
                .status(HttpStatus.OK.value())
                .message(SystemMessages.GET_ALL_USERS)
                .data(data)
                .build();

    }

    public ResponseWrapper<GetUser> getUserByUserId(
            final Integer userId) {

        log.info("Fetching user with ID: {}", userId);

        User user = usersRepository.findById(userId).orElse(null);

        if (user == null) {

            return ResponseWrapper.<GetUser>builder()
                    .status(HttpStatus.NOT_FOUND.value())
                    .message(SystemMessages.USER_NOT_FOUND)
                    .build();
        }

        final GetUser userDetails = GetUser.builder()
                .name(user.getName())
                .username(user.getUsername())
                .email(user.getEmail())
                .department(user.getDepartment())
                .userStatus(UserStatusEnum.fromCode(user.getUserStatus()).name())
                .createdOn(user.getCreatedOn())
                .build();

        return ResponseWrapper.<GetUser>builder()
                .status(HttpStatus.OK.value())
                .message(SystemMessages.GET_USER)
                .data(userDetails)
                .build();
    }

    @Transactional
    public ResponseWrapper<UpdateUserResponse> updateUserByUserId(
            final Integer userId,
            final UpdateUserRequest updateUserRequest) {

        log.info("Updating user with ID: {}", userId);

        User user = usersRepository.findById(userId).orElse(null);

        if (user == null) {

            return ResponseWrapper.<UpdateUserResponse>builder()
                    .status(HttpStatus.NOT_FOUND.value())
                    .message(SystemMessages.USER_NOT_FOUND)
                    .build();
        }

        UpdateUserResponse response;

        user.setName(updateUserRequest.getName());
        user.setEmail(updateUserRequest.getEmail());
        user.setDepartment(updateUserRequest.getDepartment());
        user.setModifiedBy(updateUserRequest.getModifiedBy());

        usersRepository.save(user);

        response = UpdateUserResponse.builder()
                .name(user.getName())
                .email(user.getEmail())
                .department(user.getDepartment())
                .build();

        return ResponseWrapper.<UpdateUserResponse>builder()
                .status(HttpStatus.OK.value())
                .message(SystemMessages.UPDATE_USER)
                .data(response)
                .build();
    }

    @Transactional
    public ResponseWrapper<DeleteUserResponse> deleteUser(
            final Integer userId,
            final DeleteUserRequest deleteUserRequest) {

        log.info("Deleting user with ID: {}", userId);

        User user = usersRepository.findById(userId).orElse(null);

        if (user == null) {
            return ResponseWrapper.<DeleteUserResponse>builder()
                    .status(HttpStatus.NOT_FOUND.value())
                    .message(SystemMessages.USER_NOT_FOUND)
                    .build();
        }

        DeleteUserResponse deleteUserResponse;

        user.setIsDeleted(true);
        user.setModifiedBy(deleteUserRequest.getModifiedBy());

        usersRepository.save(user);

        deleteUserResponse = DeleteUserResponse.builder()
                .username(user.getUsername())
                .isDeleted(user.getIsDeleted()).build();

        return ResponseWrapper.<DeleteUserResponse>builder()
                .status(HttpStatus.OK.value())
                .message(SystemMessages.DELETE_USER)
                .data(deleteUserResponse)
                .build();
    }
}
