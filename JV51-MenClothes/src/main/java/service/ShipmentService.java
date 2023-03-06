package service;

import entity.Shipment;

import java.util.List;

public interface ShipmentService {
    public Shipment getShip(int id);
    public List<Shipment> getAll(String name);
}
