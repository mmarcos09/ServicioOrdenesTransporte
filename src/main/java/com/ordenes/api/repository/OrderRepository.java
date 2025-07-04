package com.ordenes.api.repository;

import com.ordenes.api.entity.Order;
import com.ordenes.api.entity.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Repository
public interface OrderRepository extends JpaRepository<Order, UUID> {
    List<Order> findByStatus(OrderStatus status);
    List<Order> findByOriginContainingIgnoreCase(String origin);
    List<Order> findByDestinationContainingIgnoreCase(String destination);
    List<Order> findByCreatedAtBetween(Date start, Date end);
}
