package repository;

import entity.Category;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Integer> {
    @Query(value = "Insert into insert into product (categoryId) value (%1)",nativeQuery = true)
    void setId(int n);
}
