package com.example.project.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

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
    private Long id;
    @Column(name = "photoUrlId")
    private Long photoUrlId;
    @Column(name = "name")
    private String name;
    @Column(name = "location")
    private String location;
    @Column(name = "description")
    private String description;
    @Column(name = "availableSeats")
    private int availableSeats;

    public Tour(Long photoUrlId, String name, String location, String description, int availableSeats) {
        this.photoUrlId = photoUrlId;
        this.name = name;
        this.location = location;
        this.description = description;
        this.availableSeats = availableSeats;
    }
}
