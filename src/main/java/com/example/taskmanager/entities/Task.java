package com.example.taskmanager.entities;

import com.example.taskmanager.enums.TaskPriorityEnum;
import com.example.taskmanager.enums.TaskStatusEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name="tasks")
public class Task extends BaseEntity{

    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private TaskStatusEnum status;
    @Column(name = "priority")
    @Enumerated(EnumType.STRING)
    private TaskPriorityEnum priority;
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
