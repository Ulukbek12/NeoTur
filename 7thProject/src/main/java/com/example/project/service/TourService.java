package com.example.project.service;

import com.example.project.dto.BookingDto;
import com.example.project.entity.*;
import com.example.project.interfaces.TourInterface;
import com.example.project.repository.*;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
@RequiredArgsConstructor
public class TourService implements TourInterface {

    TourRepository tourRepository;
    CommentRepository commentRepository;
    CustomerRepository customerRepository;
    PhotoCommentRepository photoCommentRepository;
    EntryRepository entryRepository;
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
    public List<Comment> getComments() {
        return commentRepository.findAll();
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

    @Override
    public Optional<Entry> getEntry() {
        return entryRepository.findById(1L);
    }

    @Override
    public Tour getTourByName(String name){
      List<Tour> tours = tourRepository.findAll();
      for(Tour tour : tours){
          if(tour.getName().equalsIgnoreCase(name)){
              return tour;
          }
      }
      return null;
    }

    @Override
    public Customer bookTour(String name, BookingDto bookingDto)  {
        Tour tour = tourRepository.findByName(name);
        int availableSeats = tour.getAvailable_seats();
        int seatsOrdered = bookingDto.getSeatsOrder();

        if(availableSeats >= seatsOrdered){
        tour.setAvailable_seats(availableSeats - seatsOrdered);
        tourRepository.save(tour);

        PhotoComment photoComment = new PhotoComment();
        photoCommentRepository.save(photoComment);

        Comment comment = new Comment();
        comment.setNickname("Anonymous");
        comment.setDescription(bookingDto.getComment());
        comment.setPhotoComment(photoComment);
        comment.setTour(tour);
        commentRepository.save(comment);

        Customer customer = new Customer();
        customer.setPhone_num(bookingDto.getPhoneNum());
        customer.setSeats_order(bookingDto.getSeatsOrder());
        customer.setBooked(true);
        customer.setTour(tour);

        return customerRepository.save(customer);
        }else {
            return null;
        }
    }
}
