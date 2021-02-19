package com.example.exampreparation.services.implementations;

import com.example.exampreparation.models.entities.TaskEntity;
import com.example.exampreparation.models.entities.enums.ProgressEnum;
import com.example.exampreparation.models.serveces.TaskAddingModel;
import com.example.exampreparation.models.views.TaskViewModel;
import com.example.exampreparation.repositories.TaskRepository;
import com.example.exampreparation.security.CurrentUser;
import com.example.exampreparation.services.ClassificationService;
import com.example.exampreparation.services.TaskService;
import com.example.exampreparation.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.exampreparation.models.entities.enums.ProgressEnum.*;

@Service
public class TaskServiceImpl implements TaskService {
    private final ModelMapper modelMapper;
    private final TaskRepository taskRepository;
    private final UserService userService;
    private final ClassificationService classificationService;


    public TaskServiceImpl(ModelMapper modelMapper, TaskRepository taskRepository, UserService userService, ClassificationService classificationService) {
        this.modelMapper = modelMapper;
        this.taskRepository = taskRepository;
        this.userService = userService;
        this.classificationService = classificationService;

    }

    @Override
    public void addTask(TaskAddingModel taskAddingModel, Long userId) {
        TaskEntity current = modelMapper.map(taskAddingModel, TaskEntity.class);
        current.setUser(userService.getUser(userId));
        current.setProgress(OPEN);
        current.setClassification(classificationService.getClassification(taskAddingModel.getClassification()));
        taskRepository.save(current);
    }

    @Override
    public List<TaskViewModel> getAllTasks() {
        return taskRepository.findAll().stream().map(t->{
              TaskViewModel current=modelMapper.map(t, TaskViewModel.class);
              current.setClassification(t.getClassification().getClassificationName().name());
              current.setAssignedTo(t.getUser().getUsername());
              return  current;
                }).collect(Collectors.toList());
    }

    @Override
    public void changeProgress(Long id) {
        TaskEntity currentTask = taskRepository.findById(id).get();
        ProgressEnum progress = currentTask.getProgress();
        ProgressEnum[] values = values();
        int currValue = progress.ordinal()+1;
        if(currValue>=values.length){
           taskRepository.deleteById(id);
           return;
        }
        currentTask.setProgress(values[currValue]);
        taskRepository.save(currentTask);

    }
}
