package com.shipment.smartshipment.dto;

import com.shipment.smartshipment.entity.ShipmentStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ShipmentResponse {

    private Long id;
    private String trackingNumber;
    private String senderName;
    private String receiverName;
    private String origin;
    private String destination;
    private ShipmentStatus status;
    private LocalDateTime createdAt;
}