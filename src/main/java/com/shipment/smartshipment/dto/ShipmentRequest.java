package com.shipment.smartshipment.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShipmentRequest {

    @NotBlank(message = "Tracking number is required")
    private String trackingNumber;

    @NotBlank(message = "Sender name is required")
    private String senderName;

    @NotBlank(message = "Receiver name is required")
    private String receiverName;

    @NotBlank(message = "Origin is required")
    private String origin;

    @NotBlank(message = "Destination is required")
    private String destination;
}