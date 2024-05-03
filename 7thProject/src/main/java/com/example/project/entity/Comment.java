package com.example.project.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
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
     Long id;

    @Column(name = "nickname")
     String nickname;

    @Column(name = "description")
     String description;

    /*referencedColumnName = "id" говорит Hibernate, что внешний ключ в столбце
    photoCommentId в таблице comment будет ссылаться на столбец id в таблице photoComment.*/
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "photo_comment_id",referencedColumnName = "id")
    PhotoComment photoComment;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tour_id",referencedColumnName = "id")
    Tour tour;

    public Comment(String nickname, String description, PhotoComment photoComment, Tour tour) {
        this.nickname = nickname;
        this.description = description;
        this.photoComment = photoComment;
        this.tour = tour;
    }
}
