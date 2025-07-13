package com.user.userservice.service;

import com.user.userservice.model.User;
import com.user.userservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepo;

    @Autowired
    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public User saveUser(User user) {
        if (user.getProfile() != null) {
            user.getProfile().setUser(user);
        }
        return userRepo.save(user);
    }
}
