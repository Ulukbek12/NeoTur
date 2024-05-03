package com.example.project.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;


@Entity
@Table(name = "photo_comment")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PhotoComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @Column(name = "photo_url")
    String photo_url= "https://res.cloudinary.com/djdvbx4vj/image/upload/v1713346373/samples/NeoTur/CommentPicture.jpg";

    @JsonIgnore
    @OneToOne(mappedBy = "photoComment",fetch = FetchType.EAGER)
    Comment comment;
}
// кавычках указывается имя поле в класса comment