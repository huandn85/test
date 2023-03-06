package service;

import entity.OrderDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.OrderDetailsRepository;

import java.util.List;
@Service(value = "orderDetailService")
public class OrderDetailsImpl implements OrderDetailService{
    @Autowired
    private OrderDetailsRepository orderDetailsRepository;

    @Override
    public List<OrderDetails> getODbyId(int id) {
        return (List<OrderDetails>) orderDetailsRepository.findByOderId(id);
    }

    @Override
    public float getSumId(int id) {
        return orderDetailsRepository.getSumAm(id);
    }

}
