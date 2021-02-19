package com.example.exampreparation.services;

import com.example.exampreparation.models.entities.ClassificationEntity;

import java.util.List;

public interface ClassificationService {
    void addClassifications();
    List<String> getAllClassifications();

    ClassificationEntity getClassification(String classification);
}
