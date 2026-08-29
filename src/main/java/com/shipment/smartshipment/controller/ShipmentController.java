package com.shipment.smartshipment.controller;


import com.shipment.smartshipment.ShipmentService;
import com.shipment.smartshipment.dto.ShipmentRequest;
import com.shipment.smartshipment.dto.ShipmentResponse;
import com.shipment.smartshipment.entity.Shipment;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.shipment.smartshipment.dto.UpdateStatusRequest;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ShipmentController {
    private final ShipmentService shipmentService;
    @PostMapping("/shipments")
    public ShipmentResponse createShipment(
            @Valid @RequestBody ShipmentRequest request) {

        return shipmentService.createShipment(request);
    }
    @GetMapping("/shipments/{id}")
    public ShipmentResponse getShipmentById(@PathVariable Long id){
        return shipmentService.getShipmentById(id);
}
    @GetMapping("/shipments")
    public List<ShipmentResponse> getAllShipments() {
        return shipmentService.getAllShipments();
    }
    @DeleteMapping("/shipments/{id}")
    public String deleteShipment(@PathVariable Long id) {
        shipmentService.deleteShipment(id);
        return "Shipment deleted successfully";
    }
    @PutMapping("/shipments/{id}")
    public ShipmentResponse updateShipment(
            @PathVariable Long id,
            @Valid @RequestBody ShipmentRequest request) {

        return shipmentService.updateShipment(id, request);
    }
    @PatchMapping("/shipments/{id}/status")
    public ShipmentResponse updateShipmentStatus(
            @PathVariable Long id,
            @RequestBody UpdateStatusRequest request) {

        return shipmentService.updateShipmentStatus(id, request.getStatus());
    }


}
