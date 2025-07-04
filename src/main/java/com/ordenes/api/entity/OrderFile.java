package com.ordenes.api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderFile {

    @Id
    private UUID id;

    private String fileName;
    private String fileType;

    @Lob
    private byte[] data;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
}
