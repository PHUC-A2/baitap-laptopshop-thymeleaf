package com.phuccoder.laptopshop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.phuccoder.laptopshop.domain.User;
import com.phuccoder.laptopshop.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    public User getUserById(long id) {
        return this.userRepository.findById(id);
    }

    public User saveUser(User user) {
        return this.userRepository.save(user);
    }

    public User updateUser(User user){
        return this.userRepository.save(user);
    }

}
