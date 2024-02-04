package com.personalproj.ineedmaster.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String birthdate;
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private Role role;
}
