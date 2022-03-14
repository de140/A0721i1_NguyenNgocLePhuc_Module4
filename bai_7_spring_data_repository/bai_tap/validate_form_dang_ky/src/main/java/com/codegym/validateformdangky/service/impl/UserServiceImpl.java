package com.codegym.validateformdangky.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.codegym.validateformdangky.model.User;
import com.codegym.validateformdangky.repository.IUserRepository;
import com.codegym.validateformdangky.service.IUserService;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserRepository userRepository;


    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public User findUserById(int id) {
        return userRepository.findById(id).orElse(null);
    }
}
