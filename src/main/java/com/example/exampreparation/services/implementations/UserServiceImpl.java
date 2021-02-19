package com.example.exampreparation.services.implementations;

import com.example.exampreparation.models.entities.UserEntity;
import com.example.exampreparation.models.serveces.UserServiceModel;
import com.example.exampreparation.repositories.UserRepository;
import com.example.exampreparation.security.CurrentUser;
import com.example.exampreparation.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
    }

    @Override
    public void registerUser(UserServiceModel userServiceModel) {
        userRepository.save(modelMapper.map(userServiceModel, UserEntity.class));
    }

    @Override
    public UserServiceModel findCurrentUser(UserServiceModel userServiceModel) {
        Optional<UserEntity> user = userRepository.findByEmailAndPassword(userServiceModel.getEmail(),
                userServiceModel.getPassword());
        return user.map(u -> modelMapper.map(u, UserServiceModel.class)).orElse(null);
    }

    @Override
    public void loginUser(UserServiceModel userServiceModel) {
        long id =userServiceModel.getId();
        String email =userServiceModel.getEmail();
        currentUser.setId(id).setEmail(email);

    }

    @Override
    public void logout() {
      currentUser.setEmail(null).setId(null);
    }

    @Override
    public UserEntity getUser(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
