package com.shipment.smartshipment.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "shipment_tracking_history")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShipmentTrackingHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long shipmentId;
    @Enumerated(EnumType.STRING)
    private ShipmentStatus oldStatus;
    @Enumerated(EnumType.STRING)
    private ShipmentStatus newStatus;
    private LocalDateTime changedAt;
    @PrePersist
    protected void onCreate() {
        changedAt = LocalDateTime.now();
    }
}
