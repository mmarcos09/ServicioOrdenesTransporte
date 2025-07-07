package com.ordenes.api.repository;

import com.ordenes.api.entity.Orders;
import com.ordenes.api.entity.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Repository
public interface OrderRepository extends JpaRepository<Orders, UUID> {
    List<Orders> findByStatus(OrderStatus status);
    List<Orders> findByOriginContainingIgnoreCase(String origin);
    List<Orders> findByDestinationContainingIgnoreCase(String destination);
    List<Orders> findByCreatedAtBetween(Date start, Date end);
}
