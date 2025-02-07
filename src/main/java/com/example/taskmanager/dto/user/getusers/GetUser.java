package com.example.taskmanager.dto.user.getusers;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class GetUser {

    private String name;
    private String username;
    private String email;
    private String department;
    private String userStatus;
    private LocalDateTime createdOn;
}
