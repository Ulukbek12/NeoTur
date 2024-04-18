package com.example.project.repository;

import com.example.project.entity.PhotoComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoCommentRepository extends JpaRepository<PhotoComment,Long> {
}
