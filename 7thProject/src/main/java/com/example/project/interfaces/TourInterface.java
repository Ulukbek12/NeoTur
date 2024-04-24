package com.example.project.interfaces;

import com.example.project.entity.Tour;

import java.util.List;

public interface TourInterface {
    List<Tour> getToursByContinent(String continent);
    Tour getTourByName(String name)throws Exception;
    List<Tour> getTours();
    List<Tour> getPopularTours();
    List<Tour> getFeaturedTours();
    List<Tour> getMostVisitedTours();
    List<Tour> getRecommendedTours(String season);
}
