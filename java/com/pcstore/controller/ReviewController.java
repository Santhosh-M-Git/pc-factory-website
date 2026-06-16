package com.pcstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.pcstore.model.Review;
import com.pcstore.repository.ReviewRepository;
import org.springframework.data.domain.Sort;

@RestController
@RequestMapping("/api/reviews")
@CrossOrigin
public class ReviewController {

    @Autowired
    private ReviewRepository repo;

    @GetMapping
    public List<Review> getAll(){
        return repo.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    @PostMapping
    public Review addReview(@RequestBody Review review){
        review.setStatus("ACTIVE");   
        return repo.save(review);
    }
    
    @PutMapping("/{id}")
    public Review updateStatus(@PathVariable Long id, @RequestBody Review newData){
        Review r = repo.findById(id).get();
        r.setStatus(newData.getStatus());
        return repo.save(r);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        repo.deleteById(id);
    }
}