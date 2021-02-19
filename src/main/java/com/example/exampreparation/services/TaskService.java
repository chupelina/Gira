package com.example.exampreparation.services;

import com.example.exampreparation.models.serveces.TaskAddingModel;
import com.example.exampreparation.models.views.TaskViewModel;

import java.util.List;

public interface TaskService {
    void addTask(TaskAddingModel taskAddingModel, Long id);

    List<TaskViewModel> getAllTasks();

    void changeProgress(Long id);
}
