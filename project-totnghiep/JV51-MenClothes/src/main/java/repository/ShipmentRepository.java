package repository;

import entity.Shipment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ShipmentRepository extends CrudRepository<Shipment, Integer> {
    @Query(value = "select * from shipment as s where s.id like %?1% or s.customerName like %?1% or s.phone like %?1% or s.price like %?1% or s.address like %?1%",nativeQuery = true)
    List<Shipment> getAllShip(String name);
}
