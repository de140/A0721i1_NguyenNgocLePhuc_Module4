package com.codegym.validateformdangky.service;

import com.codegym.validateformdangky.model.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();

    void saveUser(User user);

    void deleteUser(int id);

    User findUserById(int id);
}