package com.example.project.сontroller;

import com.example.project.entity.Tour;
import com.example.project.service.TourService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class TourController {

    TourService tourService;
    @GetMapping("/tours")
    public ResponseEntity<List<Tour>> getTours(){
        return ResponseEntity.ok().body(tourService.getTours());
    }

    @GetMapping("/tours/{continent}")
    public ResponseEntity<List<Tour>> getToursByContinent(@PathVariable String continent){
        List<Tour> tours = tourService.getToursByContinent(continent);
        return ResponseEntity.ok().body(tours);
    }

    @GetMapping("/tours/popular")
    public ResponseEntity<List<Tour>> getPopularTours(){
        return ResponseEntity.ok().body(tourService.getPopularTours());
    }

    @GetMapping("/tours/featured")
    public ResponseEntity<List<Tour>> getFeaturedTours(){
        return ResponseEntity.ok().body(tourService.getFeaturedTours());
    }

    @GetMapping("/tours/mostVisited")
    public ResponseEntity<List<Tour>> getMostVisitedTours(){
        return ResponseEntity.ok().body(tourService.getMostVisitedTours());
    }

    @GetMapping("/tours/recommended/{season}")
    public ResponseEntity<List<Tour>> getRecommendedTours(@PathVariable String season){
        return ResponseEntity.ok().body(tourService.getRecommendedTours(season));
    }

}
