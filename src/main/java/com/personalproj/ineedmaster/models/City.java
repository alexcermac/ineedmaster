package com.personalproj.ineedmaster.models;

import jakarta.persistence.*;
//import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

//    @NotBlank
    private String name;

//    @NotBlank
    private Integer countyId;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "county.id")
//    private County county;
}
