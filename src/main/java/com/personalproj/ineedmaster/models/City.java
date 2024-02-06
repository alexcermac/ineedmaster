package com.personalproj.ineedmaster.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

//    @NotBlank
    private String name;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @ManyToOne
//    @JoinColumn(name = "county_id")
//    private County county;

//    @OneToMany(orphanRemoval = true)
//    @JoinColumn(name = "cityId", referencedColumnName = "id", nullable = false)
//    private List<Solution> solutions;
}
