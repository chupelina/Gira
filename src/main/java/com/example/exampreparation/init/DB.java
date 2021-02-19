package com.example.exampreparation.init;

import com.example.exampreparation.services.ClassificationService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DB implements CommandLineRunner {
    private final ClassificationService classificationService;

    public DB(ClassificationService classificationService) {
        this.classificationService = classificationService;
    }

    @Override
    public void run(String... args) throws Exception {
        classificationService.addClassifications();
    }
}
