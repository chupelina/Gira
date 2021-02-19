package com.example.exampreparation.models.serveces;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

public class TaskAddingModel {
    @Length(min = 3 , max=20, message = "Name must be between 3 and 20 characters!")
    @NotEmpty
    private String name;
    @Length(min=5, message = "Description must be more than 5 characters!")
    @NotEmpty
    private String description;
    @FutureOrPresent(message = "The date cannot be in the past!")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dueDate;
    private String classification;

    public String getName() {
        return name;
    }

    public TaskAddingModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public TaskAddingModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public TaskAddingModel setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    public String getClassification() {
        return classification;
    }

    public TaskAddingModel setClassification(String classification) {
        this.classification = classification;
        return this;
    }
}
