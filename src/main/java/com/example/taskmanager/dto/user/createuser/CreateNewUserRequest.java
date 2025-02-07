package com.example.taskmanager.dto.user.createuser;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class CreateNewUserRequest {

    private String name;
    private String email;
    private String username;
    private String password;
    private String department;
    private Integer createdBy;

}
