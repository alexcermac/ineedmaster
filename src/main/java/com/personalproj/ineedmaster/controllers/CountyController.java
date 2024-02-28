package com.personalproj.ineedmaster.controllers;

import com.personalproj.ineedmaster.models.County;
import com.personalproj.ineedmaster.service.CountyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/counties")
@RequiredArgsConstructor
@CrossOrigin
public class CountyController {
    private final CountyService countyService;

    @GetMapping
    public List<County> getAllCounties() {
        return countyService.getAllCounties();
    }
}
