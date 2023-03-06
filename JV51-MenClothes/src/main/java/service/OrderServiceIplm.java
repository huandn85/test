package service;

import entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.OrderRepository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Date;
import java.util.List;

@Service(value = "orderService")
public class OrderServiceIplm implements OrderService{
    @Autowired
    private OrderRepository orderRepository;
    @Override
    public List<Order> getAll() {
        return (List<Order>) orderRepository.findAll();
    }

    @Override
    public void addOrder(Order order) {
        orderRepository.save(order);
    }

    @Override
    public List<Order> getAllSearch(String name) {
        return (List<Order>) orderRepository.findOrderByID(name);
    }

    @Override
    public List<Order> findBydate(String name, String name1) {
        return (List<Order>) orderRepository.findOrderdate(name , name1);
    }

    @Override
    public int getTotalOr() {
        return orderRepository.getTotalOr();
    }
}
