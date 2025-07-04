package com.ordenes.api.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    private UUID id;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @Column(nullable = false)
    private String origin;

    @Column(nullable = false)
    private String destination;

    private Date createdAt;
    private Date updatedAt;

    @ManyToOne
    private Driver driver;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderFile> files;
}

