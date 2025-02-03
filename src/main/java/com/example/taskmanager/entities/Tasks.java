package com.example.taskmanager.entities;

import com.example.taskmanager.enums.TaskPriority;
import com.example.taskmanager.enums.TaskStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name="tasks")
public class Tasks extends BaseEntity{

    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private TaskStatus status;
    @Column(name = "priority")
    @Enumerated(EnumType.STRING)
    private TaskPriority priority;
    @Column(name = "assigned_to")
    private Integer assignedTo;
    @Column(name = "estimated_time")
    private Integer estimatedTime;
    @Column(name = "actual_time")
    private Integer actualTime;
    @Column(name = "due_date")
    private LocalDateTime dueDate;
    @Column(name = "completed_on")
    private LocalDateTime completedOn;

}
