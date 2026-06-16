package com.pcstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pcstore.model.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}