package com.pcstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pcstore.model.Content;

public interface ContentRepository extends JpaRepository<Content, Long> {
    List<Content> findByPage(String page);
}
