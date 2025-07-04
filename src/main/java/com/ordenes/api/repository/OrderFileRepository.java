package com.ordenes.api.repository;

import com.ordenes.api.entity.OrderFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface OrderFileRepository extends JpaRepository<OrderFile, UUID> {
    List<OrderFile> findByOrderId(UUID orderId);
}

