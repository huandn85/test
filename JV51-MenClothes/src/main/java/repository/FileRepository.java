package repository;

import entity.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FileRepository extends JpaRepository<File,Integer> {
    List<File> findAllByOrderByIdDesc();
    @Query(value = "select * from file as f where f.productId=?1", nativeQuery = true)
    List<File> findAllByProductId(int id);
    @Query(value = "select * from file as f  where f.productId limit 1", nativeQuery = true)
    File findByProductId(int id);
    @Query(value = "select * from product inner join file ON product.id=file.productId group by file.productId",nativeQuery = true)
    List<File> getAllFilebyPi();
}
