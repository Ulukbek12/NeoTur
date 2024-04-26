package com.example.project.interfaces;

import com.example.project.dto.BookingDto;
import com.example.project.entity.Comment;
import com.example.project.entity.Customer;
import com.example.project.entity.Entry;
import com.example.project.entity.Tour;

import java.util.List;
import java.util.Optional;

public interface TourInterface {
    List<Tour> getToursByContinent(String continent);
    Tour getTourByName(String name);
    Customer bookTour(String name, BookingDto bookingDto);
    List<Tour> getTours();
    List<Comment> getComments();
    List<Tour> getPopularTours();
    List<Tour> getFeaturedTours();
    List<Tour> getMostVisitedTours();
    List<Tour> getRecommendedTours(String season);
    Optional<Entry> getEntry();
}
