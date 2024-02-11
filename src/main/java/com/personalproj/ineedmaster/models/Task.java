package com.personalproj.ineedmaster.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @ManyToOne()
    @JoinColumn(name = "solution_id")
    private Solution solution;

    @ManyToOne()
    @JoinColumn(name = "customer_id")
    private User customer;

    @ManyToOne()
    @JoinColumn(name = "master_id")
    private User master;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date;
    private String startHour;
    private String endHour;

    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    private String address;
}
