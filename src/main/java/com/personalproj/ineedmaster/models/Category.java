package com.personalproj.ineedmaster.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    private String name;

    @OneToMany(orphanRemoval = true)
    @JoinColumn(name = "category_id", referencedColumnName = "id", nullable = false)
    private List<Subcategory> subcategories;
}
