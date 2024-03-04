package com.personalproj.ineedmaster.service;

import com.personalproj.ineedmaster.dto.UserDTO;
import com.personalproj.ineedmaster.dto.UserMasterDTO;
import com.personalproj.ineedmaster.exceptions.ResourceNotFoundException;
import com.personalproj.ineedmaster.models.User;
import com.personalproj.ineedmaster.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public User getLoggedInUserByEmail(String email) {
        Optional<User> user = userRepository.findByEmail(email);

        if(user.isPresent()) {
            return user.get();
        } else {
            throw new ResourceNotFoundException("User not found.");
        }
    }

    @Override
    public User getUserMasterById(Integer id) {
        Optional<User> user = userRepository.findById(id);

        if (!user.isPresent()) {
            throw new ResourceNotFoundException("Master with id " + id + " was not found.");
        }

        return user.get();
    }
}
