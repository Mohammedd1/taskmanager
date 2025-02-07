package com.example.taskmanager.controllers;

import com.example.taskmanager.common.response.ResponseWrapper;
import com.example.taskmanager.config.SystemConfig;
import com.example.taskmanager.dto.user.createuser.CreateNewUserRequest;
import com.example.taskmanager.dto.user.createuser.CreateNewUserResponse;
import com.example.taskmanager.dto.user.deleteuser.DeleteUserRequest;
import com.example.taskmanager.dto.user.deleteuser.DeleteUserResponse;
import com.example.taskmanager.dto.user.getusers.GetUser;
import com.example.taskmanager.dto.user.getusers.GetUsersResponse;
import com.example.taskmanager.dto.user.updateuser.UpdateUserRequest;
import com.example.taskmanager.dto.user.updateuser.UpdateUserResponse;
import com.example.taskmanager.services.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;


@Tag(name = "User", description = "User APIs")
@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<ResponseWrapper<CreateNewUserResponse> > createUser(
            @RequestBody final CreateNewUserRequest user) {

        ResponseWrapper<CreateNewUserResponse>  response = userService.createNewUser(user);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping()
    public ResponseEntity<ResponseWrapper<GetUsersResponse>> getUsers(
            @RequestParam(name = "page-number",
                    defaultValue = SystemConfig.DEFAULT_PAGE_NUMBER,
                    required = false) final Integer pageNumber,
            @RequestParam(name = "page-size",
                    defaultValue = SystemConfig.DEFAULT_PAGE_SIZE,
                    required = false) final Integer pageSize) {

        ResponseWrapper<GetUsersResponse> response =
                userService.getUsersList(pageNumber, pageSize);

        return ResponseEntity.status(HttpStatus.OK).body(response);

    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseWrapper<GetUser>> getUserByUserId(
            @PathVariable(name="id") final Integer userId){

        ResponseWrapper<GetUser> response=
                userService.getUserByUserId(userId);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseWrapper<UpdateUserResponse>> updateUser(
            @PathVariable(name="id") final Integer userId,
            @RequestBody final UpdateUserRequest updateUserRequest){

        ResponseWrapper<UpdateUserResponse> response=
                userService.updateUserByUserId(userId,
                        updateUserRequest);

        return ResponseEntity.status(HttpStatus.OK).body(response);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseWrapper<DeleteUserResponse>> deleteUser(
            @PathVariable(name="id") final Integer userId,
            @RequestBody final DeleteUserRequest deleteUserRequest){

        ResponseWrapper<DeleteUserResponse> response=
                userService.deleteUser(userId,
                        deleteUserRequest);

        return ResponseEntity.status(HttpStatus.OK).body(response);

    }
}
