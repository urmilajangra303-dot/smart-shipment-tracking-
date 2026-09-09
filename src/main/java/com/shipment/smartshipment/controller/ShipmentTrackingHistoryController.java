package com.shipment.smartshipment.controller;

import com.shipment.smartshipment.ShipmentTrackingHistoryService;
import com.shipment.smartshipment.entity.ShipmentTrackingHistory;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/shipments")
@RequiredArgsConstructor
public class ShipmentTrackingHistoryController {

    private final ShipmentTrackingHistoryService trackingHistoryService;
    @GetMapping("/{shipmentId}/history")
    public List<ShipmentTrackingHistory> getHistory(
            @PathVariable Long shipmentId) {

        return trackingHistoryService.getHistoryByShipmentId(shipmentId);
    }
}