package service;

import entity.Product;

import java.util.List;

public interface ProductService{
    public List<Product> getAllPro();
    public void addProduct(Product product);
    public void deleteById(int id);
    public Product getupdatePro(int id);
    public Product updatePro(Product product);
    public List<Product> getSearch(String name);
    public int getTotalPro();
    public int getEmtyPro();
    public List<Product> getAllEmties();
}
