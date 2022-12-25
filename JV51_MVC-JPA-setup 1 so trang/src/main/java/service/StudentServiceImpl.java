package service;
import entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.StudentRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service(value = "studentService")
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentRepository studentRepository;
    @Override
    public List<Student> getAllStudent() {
        return (List<Student>)studentRepository.findAll();
    }

    @Override
    public void deleteByID(int id) {
        studentRepository.deleteById(id);
    }

    @Override
    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public Student updateById(int id) {
        return studentRepository.findById(id).get();
    }

    public List<Student> getSear(LocalDate date){
        System.out.println("abc");
        return studentRepository.getAllsear(date);

    }
}
