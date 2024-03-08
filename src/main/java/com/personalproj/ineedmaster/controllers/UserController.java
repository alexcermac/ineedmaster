package com.personalproj.ineedmaster.controllers;

import com.personalproj.ineedmaster.config.JwtService;
import com.personalproj.ineedmaster.dto.UserDTO;
import com.personalproj.ineedmaster.dto.UserMasterDTO;
import com.personalproj.ineedmaster.models.User;
import com.personalproj.ineedmaster.service.IUserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@CrossOrigin
public class UserController {
    private final IUserService userService;
    private final ModelMapper modelMapper;
    private final JwtService jwtService;

    @GetMapping()
    public ResponseEntity<UserDTO> getLoggedInUserByEmail(@NonNull HttpServletRequest request) {
        final String authHeader = request.getHeader("Authorization");
        final String token;

        if(authHeader == null || !authHeader.startsWith("Bearer ")) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Token not found!");
        }

        token = authHeader.substring(7);
        String email = jwtService.extractUsername(token);
        User user = userService.getLoggedInUserByEmail(email);
        UserDTO userDto = modelMapper.map(user, UserDTO.class);

        return ResponseEntity.ok().body(userDto);
    }

    @GetMapping("/master/{id}")
    public ResponseEntity<UserMasterDTO> getUserMasterById(@PathVariable Integer id) {
        User user = userService.getUserMasterById(id);
        UserMasterDTO userMasterDTO = modelMapper.map(user, UserMasterDTO.class);

        return ResponseEntity.ok().body(userMasterDTO);
    }
}
