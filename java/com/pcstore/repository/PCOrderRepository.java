package com.pcstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pcstore.model.PCOrder;

public interface PCOrderRepository extends JpaRepository<PCOrder, Long> {
}