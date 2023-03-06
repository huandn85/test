package service;


import entity.Customer;

import java.util.List;

public interface CustomerService {
    public List<Customer> getAll(String name);
    public List<Customer> getAllCus();
    public int getTotal();
    public Customer addCus(Customer customer);
}
