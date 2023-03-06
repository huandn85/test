package service;

import entity.Category;
import entity.Product;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCa();
    void addCate(Category category);
}
