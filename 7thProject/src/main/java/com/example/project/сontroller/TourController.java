package com.example.project.сontroller;

import com.example.project.dto.BookingDto;
import com.example.project.entity.Comment;
import com.example.project.entity.Customer;
import com.example.project.entity.Entry;
import com.example.project.entity.Tour;
import com.example.project.exception.NotFoundException;
import com.example.project.service.TourService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

        @GetMapping("/tours/continent/{continent}")
        public ResponseEntity<List<Tour>> getToursByContinent(@PathVariable String continent) {
            List<Tour> tours = tourService.getToursByContinent(continent);
            if (!tours.isEmpty()) {
                return ResponseEntity.ok().body(tours);
            } else {
                return ResponseEntity.notFound().build();
            }
        }

    @GetMapping("/tours/popular")
    public ResponseEntity<List<Tour>> getPopularTours(){
        List<Tour> popularTours = tourService.getPopularTours();
        if (popularTours.isEmpty()) {
            throw new NotFoundException("No popular tours found.");
        }
        return ResponseEntity.ok().body(popularTours);
    }

    @GetMapping("/tours/featured")
    public ResponseEntity<List<Tour>> getFeaturedTours(){
        List<Tour> featuredTours = tourService.getFeaturedTours();
        if (featuredTours.isEmpty()) {
            throw new NotFoundException("No popular tours found.");
        }
        return ResponseEntity.ok().body(featuredTours);
    }

    @GetMapping("/tours/mostVisited")
    public ResponseEntity<List<Tour>> getMostVisitedTours(){
        List<Tour> mostVisitedTours = tourService.getMostVisitedTours();
        if (mostVisitedTours.isEmpty()) {
            throw new NotFoundException("No most visited tours found.");
        }
        return ResponseEntity.ok().body(mostVisitedTours);
    }

    @GetMapping("/tours/recommended/{season}")
    public ResponseEntity<List<Tour>> getRecommendedTours(@PathVariable String season){
        try {
            List<Tour> tours = tourService.getRecommendedTours(season);
            return ResponseEntity.ok().body(tours);
        } catch (IllegalArgumentException ex){
            return ResponseEntity.badRequest().body(null);
        }catch (NotFoundException ex){
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/tours/tour/{name}")
    public ResponseEntity<Tour> getTour(@PathVariable String name){
            Tour tour = tourService.getTourByName(name);
        if (tour != null) {
            return ResponseEntity.ok().body(tour);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/tours/comments")
    public ResponseEntity<List<Comment>> getComments() throws Exception {
        return ResponseEntity.ok().body(tourService.getComments());
    }

    @GetMapping("/entry")
    public ResponseEntity<Optional<Entry>> getEntry() throws Exception {
        return ResponseEntity.ok().body (tourService.getEntry());
    }
    @PostMapping("/tours/tour/{name}/booking")
    public ResponseEntity<Customer> bookTour(@PathVariable String name, @RequestBody BookingDto bookingDto) {
        try {
            Customer customer = tourService.bookTour(name, bookingDto);
            return ResponseEntity.ok().body(customer);
        } catch (NotFoundException ex) {
            return ResponseEntity.notFound().build();
        } catch (IllegalStateException | IllegalArgumentException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

}
