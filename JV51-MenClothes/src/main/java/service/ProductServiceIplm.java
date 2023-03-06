package service;

import entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import repository.ProductRepository;

import java.util.List;

@Service(value = "productService ")
public class ProductServiceIplm implements ProductService{
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllPro() {
        return (List<Product>)productRepository.findAll();
    }

    @Override
    public void addProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public void deleteById(int id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product getupdatePro(int id) {
        return productRepository.findById(id).get();
    }

    @Override
    public Product updatePro(Product product){
        return (Product) productRepository.save(product);
    }

    @Override
    public List<Product> getSearch(String name) {
        return productRepository.getSearch(name);
    }

    @Override
    public int getTotalPro() {
        return productRepository.getTotalPro();
    }

    @Override
    public int getEmtyPro() {
        return productRepository.getEmtyPro();
    }

    @Override
    public List<Product> getAllEmties() {
        return (List<Product>) productRepository.getAllEmties();
    }


}
