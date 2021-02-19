package com.example.exampreparation.models.entities;

import com.example.exampreparation.models.entities.enums.ProgressEnum;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
@Table(name= "tasks")
public class TaskEntity extends BaseEntity{
    @Column(unique = true, nullable = false)
    private String name;
    @Column(columnDefinition = "TEXT")
    private String description;
    @Column(unique = true)
    private ProgressEnum progress;
    private LocalDate dueDate;
    @ManyToOne
    private ClassificationEntity classification;
    @ManyToOne
    private UserEntity user;

    public String getName() {
        return name;
    }

    public TaskEntity setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public TaskEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    public ProgressEnum getProgress() {
        return progress;
    }

    public TaskEntity setProgress(ProgressEnum progress) {
        this.progress = progress;
        return this;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public TaskEntity setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    public ClassificationEntity getClassification() {
        return classification;
    }

    public TaskEntity setClassification(ClassificationEntity classification) {
        this.classification = classification;
        return this;
    }

    public UserEntity getUser() {
        return user;
    }

    public TaskEntity setUser(UserEntity user) {
        this.user = user;
        return this;
    }
}
