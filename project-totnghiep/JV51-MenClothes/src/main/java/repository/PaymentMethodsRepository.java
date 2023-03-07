package repository;

import entity.PaymentMethods;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PaymentMethodsRepository extends CrudRepository<PaymentMethods, Integer> {
//    @Query(value = "select * from paymentmethods as p where p.")
}
