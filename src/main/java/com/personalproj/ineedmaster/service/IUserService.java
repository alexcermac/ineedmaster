package com.personalproj.ineedmaster.service;

import com.personalproj.ineedmaster.models.User;

import java.util.Optional;

public interface IUserService {
    Optional<User> getUserById(Integer id);
}
