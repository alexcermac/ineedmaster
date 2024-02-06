package com.personalproj.ineedmaster.service;

import com.personalproj.ineedmaster.models.User;
import com.personalproj.ineedmaster.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {
    private final UserRepository userRepository;
    @Override
    public Optional<User> getUserById(Integer id) {
        return userRepository.findById(id);
    }
}
