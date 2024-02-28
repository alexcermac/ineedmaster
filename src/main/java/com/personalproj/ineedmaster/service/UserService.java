package com.personalproj.ineedmaster.service;

import com.personalproj.ineedmaster.dto.UserDTO;
import com.personalproj.ineedmaster.exceptions.ResourceNotFoundException;
import com.personalproj.ineedmaster.models.User;
import com.personalproj.ineedmaster.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public User getLoggedInUserByEmail(String email) {
//        return userRepository.findByEmail(email);
//        Optional<User> user = userService.getLoggedInUserByEmail(email);
        Optional<User> user = userRepository.findByEmail(email);

        if(user.isPresent()) {
//            UserDTO userDto = modelMapper.map(userFound, UserDTO.class);

//            return ResponseEntity.ok().body(userDto);
//            return userFound;
            return user.get();
        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            throw new ResourceNotFoundException("User not found.");
        }
    }
}
