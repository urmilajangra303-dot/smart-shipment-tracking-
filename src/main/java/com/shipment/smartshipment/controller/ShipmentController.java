package com.shipment.smartshipment.controller;


import com.shipment.smartshipment.ShipmentService;
import com.shipment.smartshipment.entity.Shipment;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ShipmentController {
    private final ShipmentService shipmentService;
    @PostMapping("/shipments")
    public Shipment createShipment(@RequestBody Shipment shipment) {
        return shipmentService.createShipment(shipment);
    }
    @GetMapping("/shipments/{id}")
    public Shipment getShipmentById(@PathVariable Long id){
        return shipmentService.getShipmentById(id);
}
}
