package com.example.exampreparation.repositories;

import com.example.exampreparation.models.entities.ClassificationEntity;
import com.example.exampreparation.models.entities.enums.ClassificationEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassificationRepository extends JpaRepository<ClassificationEntity, Long> {
    ClassificationEntity findByClassificationName(ClassificationEnum classificationEnum);
}
