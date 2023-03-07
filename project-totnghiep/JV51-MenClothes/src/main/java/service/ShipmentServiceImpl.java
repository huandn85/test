package service;

import entity.Shipment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ShipmentRepository;

import java.util.List;

@Service(value = "shipmentService")
public class ShipmentServiceImpl implements ShipmentService{
    @Autowired
    private ShipmentRepository shipmentRepository;

    @Override
    public Shipment getShip(int id) {
        return (Shipment) shipmentRepository.findById(id).get();
    }

    @Override
    public List<Shipment> getAll(String name) {
        return (List<Shipment>) shipmentRepository.getAllShip(name);
    }

}
