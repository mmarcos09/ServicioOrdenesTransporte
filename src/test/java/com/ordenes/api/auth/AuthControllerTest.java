package com.ordenes.api.auth;

import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

class AuthControllerTest {

    @Test
    void loginConUsuarioValido() {

        JwtUtil jwtUtil = new JwtUtil();
        AuthController controller = new AuthController(jwtUtil);

        AuthRequest request = new AuthRequest();
        request.setUsername("admin");
        request.setPassword("admin123");

        // Act
        ResponseEntity<?> response = controller.login(request);

        // Assert
        assertEquals(200, response.getStatusCodeValue());
        assertTrue(response.getBody().toString().contains("token"));
    }

    @Test
    void loginConUsuarioInvalido() {
        JwtUtil jwtUtil = new JwtUtil();
        AuthController controller = new AuthController(jwtUtil);

        AuthRequest request = new AuthRequest();
        request.setUsername("otro");
        request.setPassword("clave_mal");

        ResponseEntity<?> response = controller.login(request);

        assertEquals(401, response.getStatusCodeValue());
    }
}
