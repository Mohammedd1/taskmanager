package com.example.taskmanager.dto.user.getusers;

import com.example.taskmanager.enums.UserStatusEnum;
import com.example.taskmanager.repositories.pojo.GetUserPojo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class GetUsersResponse {

    private List<GetUser> users;

    public static List<GetUser> mapper(final Page<GetUserPojo> getUserPojo) {
        List<GetUser> users = new ArrayList<>();

        getUserPojo.forEach(
                pojo -> {
                    GetUser user = GetUser.builder()
                            .name(pojo.getName())
                            .email(pojo.getEmail())
                            .username(pojo.getUsername())
                            .department(pojo.getDepartment())
                            .userStatus(
                                    UserStatusEnum.fromCode(pojo.getUserStatus()).name())
                            .build();

                    users.add(user);
                }
        );

        return users;
    }
}
