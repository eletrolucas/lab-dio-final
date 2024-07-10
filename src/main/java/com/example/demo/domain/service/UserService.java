package com.example.demo.domain.service;

import com.example.demo.domain.model.User;

public interface UserService {

    User findById(Long id);

    User create(User userToCreate);
}
