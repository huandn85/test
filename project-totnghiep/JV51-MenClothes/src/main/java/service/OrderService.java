package service;

import entity.Order;

import java.util.Date;
import java.util.List;

public interface OrderService {
    public List<Order> getAll();
    public void addOrder(Order order);
    public List<Order> getAllSearch(String name);
    public List<Order> findBydate(String name,String name1);
    public int getTotalOr();
}
