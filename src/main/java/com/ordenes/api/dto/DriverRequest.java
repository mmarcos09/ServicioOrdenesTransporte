package com.ordenes.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DriverRequest {

    // Personalizar los mensajes de error de validación usando @ControllerAdvice
    @NotBlank(message = "El nombre es obligatorio")
    private String name;
    @NotBlank(message = "LicenseNumber es obligatorio")
    private String licenseNumber;
    @NotNull(message = "El campo activo es obligatorio")
    private boolean active;
}
