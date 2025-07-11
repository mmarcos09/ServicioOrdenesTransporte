package com.ordenes.api.auth;

import lombok.Data;

@Data
class AuthRequest {
    private String username;
    private String password;
}