package com.example.exampreparation.models.views;

import com.example.exampreparation.models.entities.enums.ProgressEnum;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

public class TaskViewModel {
    private Long id;
    private String name;
    private String assignedTo;
    private LocalDate dueDate;
    private String classification;
    private String progress;

    public Long getId() {
        return id;
    }

    public TaskViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public TaskViewModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public TaskViewModel setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
        return this;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public TaskViewModel setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    public String getClassification() {
        return classification;
    }

    public TaskViewModel setClassification(String classification) {
        this.classification = classification;
        return this;
    }

    public String getProgress() {
        return progress;
    }

    public TaskViewModel setProgress(String progress) {
        this.progress = progress;
        return this;
    }
}
