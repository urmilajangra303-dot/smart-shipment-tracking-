package com.shipment.smartshipment;

import com.shipment.smartshipment.entity.Shipment;
import com.shipment.smartshipment.repository.ShipmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShipmentService {
    private final ShipmentRepository shipmentRepository ;
   public  Shipment createShipment(Shipment shipment) {
        return shipmentRepository.save(shipment);
    }
}

