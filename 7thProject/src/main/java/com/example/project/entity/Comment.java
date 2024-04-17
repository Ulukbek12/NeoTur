package com.example.project.entity;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "comment")
@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "nickname")
    private String nickname;
    @Column(name = "description")
    private String description;
    @Column(name = "photoUrlId")
    private Long photoUrlId;

    public Comment(String nickname, String description, Long photoUrlId) {
        this.nickname = nickname;
        this.description = description;
        this.photoUrlId = photoUrlId;
    }
}
