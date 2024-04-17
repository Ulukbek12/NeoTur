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
     @Column(name = "phoneNum")
     String phoneNum;
     @Column(name = "seatsOrder")
     int seatsOrder;
     @Column(name = "booked")
     boolean booked;
     @Column(name = "trip")
     String trip;
    public Customer(String phoneNum, int seatsOrder, boolean booked,String trip) {
        this.phoneNum = phoneNum;
        this.seatsOrder = seatsOrder;
        this.booked = booked;
        this.trip = trip;
    }
}
