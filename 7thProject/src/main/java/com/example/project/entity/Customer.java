package com.example.project.entity;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "customer")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class Customer {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "id")
     Long id;

     @Column(name = "phone_num")
     String phone_num;

     @Column(name = "seats_order")
     int seats_order;

     @Column(name = "booked")
     boolean booked;

     @Column(name = "wishes_to_trip")
     String wishes_to_trip;

     @ManyToOne
     @JoinColumn(name = "tour_id", referencedColumnName = "id")
     Tour tour;

    public Customer(String phone_num, int seats_order, boolean booked, String wishes_to_trip, Tour tour) {
        this.phone_num = phone_num;
        this.seats_order = seats_order;
        this.booked = booked;
        this.wishes_to_trip = wishes_to_trip;
        this.tour = tour;
    }
}
