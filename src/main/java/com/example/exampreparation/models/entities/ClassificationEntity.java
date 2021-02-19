package com.example.exampreparation.models.entities;

import com.example.exampreparation.models.entities.enums.ClassificationEnum;

import javax.persistence.*;

@Entity
@Table(name = "classifications")
public class ClassificationEntity extends BaseEntity {
    @Column(unique = true)
    @Enumerated(value = EnumType.STRING)
    private ClassificationEnum classificationName;
    @Column(columnDefinition = "TEXT")
    private String description;

    public ClassificationEntity() {
    }

    public ClassificationEntity(ClassificationEnum classificationName) {
        this.classificationName = classificationName;
    }

    public ClassificationEnum getClassificationName() {
        return classificationName;
    }

    public ClassificationEntity setClassificationName(ClassificationEnum classificationName) {
        this.classificationName = classificationName;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ClassificationEntity setDescription(String description) {
        this.description = description;
        return this;
    }
}
