package com.example.project.service;

import com.example.project.entity.Tour;
import com.example.project.interfaces.TourInterface;
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
public class TourService implements TourInterface {

    TourRepository tourRepository;

    @Override
    public List<Tour> getToursByContinent(String continent) {
        List<Tour> tours = tourRepository.findAll();
        return tours.stream()
                .filter(tour -> tour.getContinent().equalsIgnoreCase(continent))
                .collect(Collectors.toList());
    }
    @Override
    public List<Tour> getTours() {
        return tourRepository.findAll();
    }

    @Override
    public List<Tour> getPopularTours() {
        List<Tour> tours = tourRepository.findAll();
        return tours.stream()
                .filter(Tour::isPopular)
                .collect(Collectors.toList());
    }

    @Override
    public List<Tour> getFeaturedTours() {
        List<Tour> tours = tourRepository.findAll();
        return tours.stream()
                .filter(Tour::isFeatured)
                .collect(Collectors.toList());
    }

    @Override
    public List<Tour> getMostVisitedTours() {
        List<Tour> tours = tourRepository.findAll();
        return tours.stream()
                .filter(tour -> tour.getAvailable_seats() <= 50)
                .collect(Collectors.toList());
    }

    @Override
    public List<Tour> getRecommendedTours(String season) {
        List<Tour> tours = tourRepository.findAll();
        return switch (season){
            case "winter" ->
                 tours.stream()
                        .filter(tour -> tour.getSeason().name().equalsIgnoreCase("winter"))
                        .collect(Collectors.toList());
            case "spring" ->
                    tours.stream()
                            .filter(tour -> tour.getSeason().name().equalsIgnoreCase("spring"))
                            .collect(Collectors.toList());
            case "summer" ->
                tours.stream()
                        .filter(tour -> tour.getSeason().name().equalsIgnoreCase("summer"))
                        .collect(Collectors.toList());
            case "autumn" ->
                tours.stream()
                        .filter(tour -> tour.getSeason().name().equalsIgnoreCase("autumn"))
                        .collect(Collectors.toList());
            default -> throw new IllegalStateException("Unexpected value: " + season);
        };
    }



}
