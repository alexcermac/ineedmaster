package com.personalproj.ineedmaster.dto;

import com.personalproj.ineedmaster.models.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private Integer id;
    private String email;
    private String firstName;
    private String lastName;
    private String birthdate;
    private String phoneNumber;
    private Role role;
}