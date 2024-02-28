package com.personalproj.ineedmaster.service;

import com.personalproj.ineedmaster.dto.UserDTO;
import com.personalproj.ineedmaster.models.User;

import java.util.Optional;

public interface IUserService {
    User getLoggedInUserByEmail(String email);
}
