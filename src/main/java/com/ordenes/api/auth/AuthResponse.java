package com.ordenes.api.auth;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
class AuthResponse {
    private String token;
}
