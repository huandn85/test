package repository;

import entity.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Date;
import java.util.List;

public interface OrderRepository extends CrudRepository<Order , Integer> {
    @Query(value= "SELECT* FROM orders as o INNER JOIN account as a On o.accountId = a.id inner join shipment On o.shipmentId = shipment.id inner join orderdetails On o.id = orderdetails.orderId where o.id like %?1% or a.name like %?1% or o.orderDate like %?1% or o.amount like %?1%", nativeQuery = true)
    List<Order> findOrderByID(String name );
    @Query(value = "SELECT* FROM orders as o where o.orderDate BETWEEN ?1 and ?2",nativeQuery = true)
    List<Order> findOrderdate(String date1,String date2);
    @Query(value = "select count(id) from orders", nativeQuery = true)
    int getTotalOr();
}
