package entity;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "student")
public class Student{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private double avgmark;
    private String level;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    public Student() {
    }

    public Student(int id, String name, double avgmark, String level, LocalDate date) {
        this.id = id;
        this.name = name;
        this.avgmark = avgmark;
        this.level = level;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAvgmark() {
        return avgmark;
    }

    public void setAvgmark(double avgmark) {
        this.avgmark = avgmark;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
