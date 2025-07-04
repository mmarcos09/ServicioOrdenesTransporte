package com.ordenes.api.service;

import com.ordenes.api.entity.Driver;
import com.ordenes.api.repository.DriverRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverService {

    private final DriverRepository driverRepository;

    public DriverService(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    public Driver create(Driver driver) {
        return driverRepository.save(driver);
    }

    public List<Driver> getActiveDrivers() {
        return driverRepository.findByActiveDriver();
    }
}
