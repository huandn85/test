package service;

import entity.OrderDetails;

import java.util.List;

public interface OrderDetailService {
    public List<OrderDetails> getODbyId(int id);
    public float getSumId(int id);
}
