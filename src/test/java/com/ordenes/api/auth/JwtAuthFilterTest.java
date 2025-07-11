package com.ordenes.api.auth;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.FilterChainProxy;

import jakarta.servlet.FilterChain;

import static org.junit.jupiter.api.Assertions.*;

class JwtAuthFilterTest {

    @Test
    void tokenValidoDebeAutenticarUsuario() throws Exception {
        // Arrange
        JwtUtil jwtUtil = new JwtUtil();
        JwtAuthFilter filter = new JwtAuthFilter(jwtUtil);

        String token = jwtUtil.generateToken("usuarioPrueba");

        MockHttpServletRequest request = new MockHttpServletRequest();
        request.addHeader("Authorization", "Bearer " + token);

        MockHttpServletResponse response = new MockHttpServletResponse();
        FilterChain chain = Mockito.mock(FilterChain.class);

        // Act
        filter.doFilterInternal(request, response, chain);

        // Assert
        assertNotNull(SecurityContextHolder.getContext().getAuthentication());
        assertEquals("usuarioPrueba", SecurityContextHolder.getContext().getAuthentication().getName());
    }
}
