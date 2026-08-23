package com.shipment.smartshipment.controller;


import com.shipment.smartshipment.ShipmentService;
import com.shipment.smartshipment.entity.Shipment;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ShipmentController {
    private final ShipmentService shipmentService;
    @PostMapping("/shipments")
    public Shipment createShipment(
            @Valid @RequestBody Shipment shipment) {

        return shipmentService.createShipment(shipment);
    }
    @GetMapping("/shipments/{id}")
    public Shipment getShipmentById(@PathVariable Long id){
        return shipmentService.getShipmentById(id);
}
    @GetMapping("/shipments")
    public List<Shipment> getAllShipments() {
        return shipmentService.getAllShipments();
    }
    @DeleteMapping("/shipments/{id}")
    public String deleteShipment(@PathVariable Long id) {
        shipmentService.deleteShipment(id);
        return "Shipment deleted successfully";
    }
    @PutMapping("/shipments/{id}")
    public Shipment updateShipment(
            @PathVariable Long id,
            @RequestBody Shipment shipment) {

        return shipmentService.updateShipment(id, shipment);
    }
}
