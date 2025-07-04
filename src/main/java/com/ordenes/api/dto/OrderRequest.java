package com.ordenes.api.dto;

import lombok.Data;

@Data
public class OrderRequest {
    private String origin;
    private String destination;
}
