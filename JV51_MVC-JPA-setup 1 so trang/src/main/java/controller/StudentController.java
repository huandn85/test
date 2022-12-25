package controller;

import entity.Student;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import service.StudentServiceImpl;


import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private StudentServiceImpl studentService;

    @RequestMapping(value = {"requestlist"},method = RequestMethod.GET)
    public String getAllStudent(Model model){
        List<Student> students = studentService.getAllStudent();
        model.addAttribute("students", students);
        System.out.println("abc");
        return "indexlist";
    }
//@RequestMapping(value = {"request"},method = RequestMethod.GET)
//    public String getSear(@RequestParam(name = "date") LocalDate date, Model model){
//        List<Student> students = studentService.getSear(date);
//    System.out.println(date);
//    System.out.printf("abc");
//        model.addAttribute("students" , students);
//        return "indexlist";
//    }
    @RequestMapping(value = "rqproduct", method = RequestMethod.GET)
    public String product(){
        return "product";
    }

    @RequestMapping(value = "delete" , method = RequestMethod.GET)
    public String deleteById(@RequestParam(name="id")int id){
        studentService.deleteByID(id);
        return "redirect:/";
    }
    @RequestMapping(value = {"requestAddStudent" ,"addStudent"}, method = RequestMethod.GET)
    public String requestAddStudent(Model model){
        model.addAttribute("student", new Student());
        return "addStudent";
    }
    @RequestMapping(value = "addStudent" ,method = RequestMethod.POST)
    public String addStudent(@ModelAttribute Student student){
        studentService.addStudent(student);
        return "redirect:/";
    }
    @RequestMapping(value = {"requestId","updateStudent"},method = RequestMethod.GET)
    public String findById(@RequestParam(name="id")int id, Model model){
        Student student = (Student) studentService.updateById(id);
        model.addAttribute("student",student);
        return "updateStudent";
    }
    @RequestMapping(value = "updateStudent" ,method = RequestMethod.POST)
    public String updateStudent(@ModelAttribute Student student){
        studentService.addStudent(student);
        return "redirect:/";
    }
    @RequestMapping(value = "abc" ,method = RequestMethod.GET)
    public String test(@RequestParam(name = "name")String name ,Model model){
        model.addAttribute("name", name);
        return "index";
    }


}
