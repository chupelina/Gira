package com.example.exampreparation.services.implementations;

import com.example.exampreparation.models.entities.ClassificationEntity;
import com.example.exampreparation.models.entities.enums.ClassificationEnum;
import com.example.exampreparation.services.ClassificationService;
import com.example.exampreparation.repositories.ClassificationRepository;
import org.springframework.stereotype.Service;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClassificationServiceImpl implements ClassificationService {
    private final ClassificationRepository classificationRepository;

    public ClassificationServiceImpl(ClassificationRepository classificationRepository) {
        this.classificationRepository = classificationRepository;
    }

    @Override
    public void addClassifications() {
        if(classificationRepository.count()!=0){
            return;
        }
        Arrays.stream(ClassificationEnum.values()).forEach(v->{
            ClassificationEntity classificationEntity = new ClassificationEntity(v);
            classificationRepository.save(classificationEntity);
        });
    }

    @Override
    public List<String> getAllClassifications() {
        return classificationRepository.findAll().stream().map(c->c.getClassificationName().name())
                .collect(Collectors.toList());
    }

    @Override
    public ClassificationEntity getClassification(String classification) {
        return classificationRepository.findByClassificationName(ClassificationEnum.valueOf(classification));
    }
}
