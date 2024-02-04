package com.personalproj.ineedmaster.models;

import jakarta.persistence.*;
//import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class County {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

//    @NotBlank
    private String name;

//    @OneToMany(mappedBy = "county", orphanRemoval = true)
    @OneToMany(orphanRemoval = true)
    @JoinColumn(name = "countyId", referencedColumnName = "id")
    private List<City> cities;
}
