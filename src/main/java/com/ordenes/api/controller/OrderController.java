package com.ordenes.api.controller;
import com.ordenes.api.dto.OrderRequest;
import com.ordenes.api.entity.Order;
import com.ordenes.api.entity.OrderStatus;
import com.ordenes.api.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    // Crear orden
    @PostMapping("/createDriver")
    public ResponseEntity<Order> createOrder(@Valid @RequestBody OrderRequest dto) {
        return ResponseEntity.ok(orderService.create(dto));
    }

    //Listar ordenes
    @GetMapping
    public ResponseEntity<List<Order>> getAll(@RequestParam(required = false) OrderStatus status, @RequestParam(required = false) String origin, @RequestParam(required = false) String destination) {
        return ResponseEntity.ok(orderService.getFilteredOrders(status, origin, destination));
    }

    //Obtener orden por id
    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable UUID id) {
        return orderService.getById(id)
                .map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    //Asignar conductor
    @PutMapping("/{id}/assign")
    public ResponseEntity<Order> assignDriver(@PathVariable UUID id, @RequestBody UUID driverId) {
        Optional<Order> updated = orderService.assignDriver(id, driverId);
        return updated.map(ResponseEntity::ok).orElse(ResponseEntity.badRequest().build());
    }

    //Cambiar estatus orden
    @PatchMapping("/{id}/updateStatus")
    public ResponseEntity<Order> updateStatus(@PathVariable UUID id, @RequestBody String status) throws  Exception {
        return ResponseEntity.ok(orderService.updateStatus(id, status));
    }




}