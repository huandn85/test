package service;

import entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.CategoryRepository;

import java.util.List;

@Service(value = "categoryService")
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCa() {
        return (List<Category>) categoryRepository.findAll();
    }
    @Override
    public void addCate(Category category){
        categoryRepository.save(category);
    }
}
