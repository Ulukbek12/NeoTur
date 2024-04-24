package com.example.project.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tour")
@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
     Long id;

    @Column(name = "name")
     String name;

    @Column(name = "location")
     String location;

    @Column(name = "description")
     String description;

    @Column(name = "available_seats")
    int available_seats;

    @Column(name = "season")
    @Enumerated(EnumType.STRING)
    Season season;

    @Column(name = "popular")
    boolean  popular;

    @Column(name = "featured")
    boolean  featured;

    @OneToOne
    @JoinColumn(name = "photo_tour_id",referencedColumnName = "id")
    PhotoTour photoTour;

    @OneToMany(mappedBy = "tour")
    List<Customer> customers = new ArrayList<>();


    @OneToMany(mappedBy = "tour")
    List<Comment> comments = new ArrayList<>();


    public Tour(String name, String location, String description, int available_seats, Season season, boolean popular, boolean featured) {
        this.name = name;
        this.location = location;
        this.description = description;
        this.available_seats = available_seats;
        this.season = season;
        this.popular = popular;
        this.featured = featured;
    }

    public Tour(String name, String description, PhotoTour photoTour) {
        this.name = name;
        this.description = description;
        this.photoTour = photoTour;
    }

    public String getContinent(){
        String location = this.location.toLowerCase();
        if(location.contains("europe")){
            return "Europe";
        }
        else if(location.contains("asia")){
            return "Asia";
        }
        else if(location.contains("north")){
            return "North America";
        }
        else if(location.contains("south")){
            return "South America";
        }
        else{
            return "Africa";
        }
    }
}
