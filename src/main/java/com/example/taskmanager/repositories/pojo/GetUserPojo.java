package com.example.taskmanager.repositories.pojo;

import java.time.LocalDateTime;

public interface GetUserPojo {

    String getName();
    String getUsername();
    String getEmail();
    String getDepartment();
    LocalDateTime getCreatedOn();
    Integer getUserStatus();

}
