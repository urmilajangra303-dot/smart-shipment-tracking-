package com.shipment.smartshipment;

import com.shipment.smartshipment.entity.Shipment;
import com.shipment.smartshipment.repository.ShipmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;



import java.util.List;

@Service
@RequiredArgsConstructor
public class ShipmentService {
    private final ShipmentRepository shipmentRepository ;
   public  Shipment createShipment(Shipment shipment) {
        return shipmentRepository.save(shipment);
    }
    public Shipment getShipmentById(Long id){
       return shipmentRepository.findById(id)
               .orElseThrow(() -> new RuntimeException("Shipment not found with id :" +id));
    }
    public List<Shipment> getAllShipments(){
       return shipmentRepository.findAll();
    }
    public void deleteShipment(Long id) {

        if (!shipmentRepository.existsById(id)) {
            throw new RuntimeException("Shipment not found with id :" + id);
        }

        shipmentRepository.deleteById(id);
    }
    public Shipment updateShipment(Long id, Shipment updatedShipment) {

        Shipment existingShipment = shipmentRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Shipment not found with id :" + id));

        existingShipment.setTrackingNumber(updatedShipment.getTrackingNumber());
        existingShipment.setSenderName(updatedShipment.getSenderName());
        existingShipment.setReceiverName(updatedShipment.getReceiverName());
        existingShipment.setOrigin(updatedShipment.getOrigin());
        existingShipment.setDestination(updatedShipment.getDestination());
        existingShipment.setStatus(updatedShipment.getStatus());

        return shipmentRepository.save(existingShipment);
    }
}

