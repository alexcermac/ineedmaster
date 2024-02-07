package com.personalproj.ineedmaster.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class County {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    private String name;

    @OneToMany(orphanRemoval = true)
    @JoinColumn(name = "countyId", referencedColumnName = "id", nullable = false)
    private List<City> cities;
}
