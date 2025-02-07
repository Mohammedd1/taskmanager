package com.example.taskmanager.dto.user.deleteuser;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class DeleteUserRequest {

    private Integer modifiedBy;
}
