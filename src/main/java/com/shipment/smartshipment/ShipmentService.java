package com.shipment.smartshipment;

import com.shipment.smartshipment.dto.ShipmentRequest;
import com.shipment.smartshipment.entity.Shipment;
import com.shipment.smartshipment.entity.ShipmentStatus;
import com.shipment.smartshipment.repository.ShipmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.shipment.smartshipment.exception.ShipmentNotFoundException;


import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ShipmentService {
    private final ShipmentRepository shipmentRepository ;
    public Shipment createShipment(ShipmentRequest request) {

        Shipment shipment = new Shipment();

        shipment.setTrackingNumber(request.getTrackingNumber());
        shipment.setSenderName(request.getSenderName());
        shipment.setReceiverName(request.getReceiverName());
        shipment.setOrigin(request.getOrigin());
        shipment.setDestination(request.getDestination());

        shipment.setStatus(ShipmentStatus.CREATED);
        shipment.setCreatedAt(LocalDateTime.now());

        return shipmentRepository.save(shipment);
    }
    public Shipment getShipmentById(Long id){
       return shipmentRepository.findById(id)
               .orElseThrow(() ->
                       new ShipmentNotFoundException("Shipment not found with id: " + id));
    }
    public List<Shipment> getAllShipments(){
       return shipmentRepository.findAll();
    }
    public void deleteShipment(Long id) {

        if (!shipmentRepository.existsById(id)) {
            throw new  ShipmentNotFoundException("Shipment not found with id :" + id);
        }

        shipmentRepository.deleteById(id);
    }
    public Shipment updateShipment(Long id, Shipment updatedShipment) {

        Shipment existingShipment = shipmentRepository.findById(id)
                .orElseThrow(() ->
                        new ShipmentNotFoundException("Shipment not found with id: " + id));

        existingShipment.setTrackingNumber(updatedShipment.getTrackingNumber());
        existingShipment.setSenderName(updatedShipment.getSenderName());
        existingShipment.setReceiverName(updatedShipment.getReceiverName());
        existingShipment.setOrigin(updatedShipment.getOrigin());
        existingShipment.setDestination(updatedShipment.getDestination());
        existingShipment.setStatus(updatedShipment.getStatus());

        return shipmentRepository.save(existingShipment);
    }
    public Shipment updateShipmentStatus(Long id, ShipmentStatus newStatus) {

        Shipment shipment = shipmentRepository.findById(id)
                .orElseThrow(() ->
                        new ShipmentNotFoundException("Shipment not found with id : " + id));

        ShipmentStatus currentStatus = shipment.getStatus();
        if (!isValidTransition(currentStatus, newStatus)) {
            throw new IllegalStateException(
                    "Invalid status transition from "
                            + currentStatus + " to " + newStatus);
        }


        shipment.setStatus(newStatus);

        return shipmentRepository.save(shipment);
    }
    private boolean isValidTransition(
            ShipmentStatus currentStatus,
            ShipmentStatus newStatus) {

        return switch (currentStatus) {

            case CREATED ->
                    newStatus == ShipmentStatus.IN_TRANSIT
                            || newStatus == ShipmentStatus.CANCELLED;

            case IN_TRANSIT ->
                    newStatus == ShipmentStatus.OUT_FOR_DELIVERY
                            || newStatus == ShipmentStatus.CANCELLED;

            case OUT_FOR_DELIVERY ->
                    newStatus == ShipmentStatus.DELIVERED
                            || newStatus == ShipmentStatus.CANCELLED;

            case DELIVERED, CANCELLED ->
                    false;
        };
    }
    }

