package service;

import entity.Student;

import java.time.LocalDate;
import java.util.List;

public interface StudentService {
    public List<Student> getAllStudent();
    public void  deleteByID(int id);
    public void addStudent(Student student);
    public Student updateById(int id);
    public List<Student>getSear(LocalDate date);
}
