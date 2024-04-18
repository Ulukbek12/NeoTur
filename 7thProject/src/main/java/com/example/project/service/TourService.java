package com.example.project.service;

import com.example.project.entity.Tour;
import com.example.project.repository.TourRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
@RequiredArgsConstructor
public class TourService {

    TourRepository tourRepository;
    public List<Tour> getToursByContinent(String continent) {
        List<Tour> tours = tourRepository.findAll();
        return tours.stream()
                .filter(tour -> tour.getContinent().equalsIgnoreCase(continent))
                .collect(Collectors.toList());
    }
    public List<Tour> getTours() {
        return tourRepository.findAll();
    }
}
