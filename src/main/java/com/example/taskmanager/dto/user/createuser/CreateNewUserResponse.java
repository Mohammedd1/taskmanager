package com.example.taskmanager.dto.user.createuser;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class CreateNewUserResponse {

    private String name;
    private String email;
    private String username;
    private String department;
}
