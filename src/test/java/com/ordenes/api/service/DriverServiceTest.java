package com.ordenes.api.service;

import com.ordenes.api.entity.Driver;
import com.ordenes.api.repository.DriverRepository;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.UUID;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DriverServiceTest {

    @Test
    void getActiveDrivers_debeRetornarListaDeConductoresActivos() {

        //Crea un repositorio simulado (mock)
        DriverRepository mockRepository = mock(DriverRepository.class);
        DriverService driverService = new DriverService(mockRepository);

        Driver driver1 = new Driver();
        driver1.setId(UUID.randomUUID());
        driver1.setName("Juan");
        driver1.setLicenseNumber("1234567890");
        driver1.setActive(true);

        Driver driver2 = new Driver();
        driver2.setId(UUID.randomUUID());
        driver2.setName("Ana");
        driver1.setLicenseNumber("0987654321");
        driver2.setActive(true);

        List<Driver> listaSimulada = List.of(driver1, driver2);

        // Configura el mock para devolver esa lista cuando se llame findByActiveTrue()
        when(mockRepository.findByActiveTrue()).thenReturn(listaSimulada);

        // Act
        List<Driver> resultado = driverService.getActiveDrivers();

        // Assert
        assertEquals(2, resultado.size());
        assertEquals("Juan", resultado.get(0).getName());
        assertTrue(resultado.get(1).isActive());

        // Verifica que se llamó una sola vez al método del repositorio
        verify(mockRepository, times(1)).findByActiveTrue();
    }
}
