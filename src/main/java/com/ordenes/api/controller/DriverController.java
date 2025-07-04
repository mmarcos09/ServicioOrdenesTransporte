package com.ordenes.api.controller;

import com.ordenes.api.entity.Driver;
import com.ordenes.api.service.DriverService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/drivers")
public class DriverController {

    private final DriverService driverService;

    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    //Crear conductor
    @PostMapping
    public ResponseEntity<Driver> createDriver(@RequestBody Driver driver) {
        return ResponseEntity.ok(driverService.create(driver));
    }

    //Listar todos los consductores activos
    @GetMapping("/active")
    public ResponseEntity<List<Driver>> getActiveDrivers() {
        return ResponseEntity.ok(driverService.getActiveDrivers());
    }
}
