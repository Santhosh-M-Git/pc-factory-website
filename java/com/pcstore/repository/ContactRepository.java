package com.pcstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pcstore.model.ContactMessage;

public interface ContactRepository extends JpaRepository<ContactMessage, Long> {
}