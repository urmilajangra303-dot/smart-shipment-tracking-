package com.shipment.smartshipment.dto;


import com.shipment.smartshipment.entity.ShipmentStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateStatusRequest {
    private ShipmentStatus status ;
}
