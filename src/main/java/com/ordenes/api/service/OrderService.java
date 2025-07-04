package com.ordenes.api.service;

import com.ordenes.api.dto.OrderRequest;
import com.ordenes.api.entity.Driver;
import com.ordenes.api.entity.Order;
import com.ordenes.api.entity.OrderStatus;
import com.ordenes.api.repository.DriverRepository;
import com.ordenes.api.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrderService {

    private OrderRepository orderRepository;
    private DriverRepository driverRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order create(OrderRequest dto) {
        Order order = new Order();
        order.setOrigin(dto.getOrigin());
        order.setDestination(dto.getDestination());
        return orderRepository.save(order);
    }

    public Optional<Order> getById(UUID id) {
        return orderRepository.findById(id);
    }

    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    public List<Order> getFilteredOrders(OrderStatus status, String origin, String destination) {
        List<Order> result = orderRepository.findAll();

        if (status != null) {
            result.removeIf(o -> !o.getStatus().equals(status));
        }
        if (origin != null && !origin.isEmpty()) {
            result.removeIf(o -> !o.getOrigin().contains(origin));
        }
        if (destination != null && !destination.isEmpty()) {
            result.removeIf(o -> !o.getDestination().contains(destination));
        }

        return result;
    }

    public Optional<Order> assignDriver(UUID orderId, UUID driverId) {
        Optional<Order> orderOpt = orderRepository.findById(orderId);
        Optional<Driver> driverOpt = driverRepository.findById(driverId);

        if (orderOpt.isPresent() && driverOpt.isPresent()) {
            Order order = orderOpt.get();
            Driver driver = driverOpt.get();

            if (order.getStatus() == OrderStatus.CREATED && driver.isActive()) {
                order.setDriver(driver);
                order.setUpdatedAt(new Date());
                return Optional.of(orderRepository.save(order));
            }
        }
        return Optional.empty() ;
    }

    public Order updateStatus(UUID orderId, String newStatus) throws Exception {
        Order order = orderRepository.findById(orderId).orElseThrow(() -> new Exception("Orden no encontrada"));

        OrderStatus status = OrderStatus.valueOf(newStatus);;

        if ((order.getStatus() == OrderStatus.CREATED
                && (status == OrderStatus.IN_TRANSIT || status == OrderStatus.CANCELLED))
                || (order.getStatus() == OrderStatus.IN_TRANSIT && status == OrderStatus.DELIVERED)) {

            order.setStatus(status);
            order.setUpdatedAt(new Date());

        }
        return orderRepository.save(order);
    }



}

