package repository;

import entity.UpFile;
import org.springframework.data.repository.CrudRepository;

public interface MRepository extends CrudRepository<UpFile, Integer > {
}
