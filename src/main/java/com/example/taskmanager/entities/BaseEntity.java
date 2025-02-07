package com.example.taskmanager.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "is_deleted")
    private Boolean isDeleted;

    @Column(name = "created_by")
    private Integer createdBy;

    @CreatedDate
    @Column(name = "created_on")
    private LocalDateTime createdOn;

    @Column(name = "modified_by")
    private Integer modifiedBy;

    @LastModifiedDate
    @Column(name = "modified_on")
    private LocalDateTime modifiedOn;

}
