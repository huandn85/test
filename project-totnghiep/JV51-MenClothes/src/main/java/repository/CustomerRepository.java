package repository;

import entity.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
    @Query(value = "select * from customer as c where c.id like %?1% or c.name like %?1% or c.address like %?1% or c.phone like %?1% or c.email like %?1%" , nativeQuery = true)
    List<Customer> getAllCus(String name);
    @Query(value = "select count(id) from customer",nativeQuery = true)
    int getTotal();
}
