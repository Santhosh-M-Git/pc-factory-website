package com.pcstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.pcstore.model.PCOrder;
import com.pcstore.repository.PCOrderRepository;

import org.springframework.data.domain.Sort;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin
public class PCOrderController {

    @Autowired
    private PCOrderRepository repository;

    @PostMapping
    public PCOrder saveOrder(@RequestBody PCOrder order) {
        return repository.save(order);
    }

    @GetMapping
    public java.util.List<PCOrder> getAllOrders() {
        return repository.findAll(Sort.by(Sort.Direction.DESC,"id"));
    }
    
    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id){
    repository.deleteById(id);
    }
}