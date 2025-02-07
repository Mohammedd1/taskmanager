package com.example.taskmanager.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@Builder
@Entity
@Table(name="users")
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "username", unique = true, nullable = false)
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "department")
    private String department;

    @Column(name="user_status")
    private Integer userStatus;

}
