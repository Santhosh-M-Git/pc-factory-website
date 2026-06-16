package com.pcstore.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.pcstore.model.ContactMessage;
import com.pcstore.repository.ContactRepository;

import org.springframework.data.domain.Sort;

@RestController
@RequestMapping("/api/contact")
@CrossOrigin("*")
public class ContactController {

@Autowired
private ContactRepository repo;

@PostMapping
public ContactMessage save(@RequestBody ContactMessage msg){
return repo.save(msg);
}

@GetMapping
public List<ContactMessage> getAll(){
return repo.findAll(Sort.by(Sort.Direction.DESC,"id"));
}

}