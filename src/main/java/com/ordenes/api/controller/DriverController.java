package com.ordenes.api.controller;

import com.ordenes.api.dto.DriverRequest;
import com.ordenes.api.entity.Driver;
import com.ordenes.api.service.DriverService;
import jakarta.validation.Valid;
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
    @PostMapping("/createDriver")
    public ResponseEntity<Driver> createDriver(@Valid @RequestBody DriverRequest dto) {
        return ResponseEntity.ok(driverService.create(dto));
    }

    //Listar todos los consductores activos
    @GetMapping("/activeDrivers")
    public ResponseEntity<List<Driver>> getActiveDrivers() {
        return ResponseEntity.ok(driverService.getActiveDrivers());
    }
}
