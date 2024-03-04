package com.personalproj.ineedmaster.service;

import com.personalproj.ineedmaster.dto.UserMasterDTO;
import com.personalproj.ineedmaster.models.User;

import java.util.List;

public interface IUserService {
    User getLoggedInUserByEmail(String email);
    User getUserMasterById(Integer id);
}
