package repository;

import entity.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface StudentRepository extends CrudRepository<Student, Integer> {
@Query(value = "select *from student s where s.date = ?1 ",nativeQuery = true)
    List<Student>getAllsear(LocalDate date);
}
