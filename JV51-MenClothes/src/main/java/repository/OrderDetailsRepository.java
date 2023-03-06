package repository;

import entity.OrderDetails;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderDetailsRepository extends CrudRepository<OrderDetails,Integer> {
    @Query(value = "select * from  orderdetails as od inner join orders as o On od.orderId = o.id where od.orderId= ?1",nativeQuery = true)
    List<OrderDetails> findByOderId(int id);
    @Query(value = "select sum(amount) from orderdetails where orderId=?1",nativeQuery = true)
    float getSumAm(int id);
}
