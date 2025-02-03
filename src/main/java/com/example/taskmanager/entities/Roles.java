package com.example.taskmanager.entities;

import io.swagger.v3.core.util.Json;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "roles")
public class Roles extends BaseEntity{

    @Column(name="role_name")
    private String roleName;

    @Column(name="description")
    private String description;

    @Column(name="permissions")
    private List<String> permissions;
}
