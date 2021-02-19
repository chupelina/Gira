package com.example.exampreparation.services;

import com.example.exampreparation.models.entities.UserEntity;
import com.example.exampreparation.models.serveces.UserServiceModel;

public interface UserService {
    void registerUser(UserServiceModel userServiceModel);

    UserServiceModel findCurrentUser(UserServiceModel userServiceModel);

    void loginUser(UserServiceModel userServiceModel);

    void logout();

    UserEntity getUser(Long id);

}
