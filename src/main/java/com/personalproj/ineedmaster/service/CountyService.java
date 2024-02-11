package com.personalproj.ineedmaster.service;

import com.personalproj.ineedmaster.models.County;
import com.personalproj.ineedmaster.repository.CountyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CountyService implements ICountyService {
    public final CountyRepository countyRepository;
    @Override
    public List<County> getAllCounties() {
        return countyRepository.findAll();
    }
}
