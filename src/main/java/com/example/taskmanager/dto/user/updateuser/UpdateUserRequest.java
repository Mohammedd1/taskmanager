package com.example.taskmanager.dto.user.updateuser;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class UpdateUserRequest {

    private String name;
    private String email;
    private String department;
    private Integer modifiedBy;
}
