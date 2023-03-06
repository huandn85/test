package entity;

import java.io.Serializable;


import javax.persistence.*;


public class MyFile  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private static final long serialVersionUID = 1L;
    private String name;
    private String imageUrl;

    public MyFile() {
    }

    public MyFile(int id, String name, String imageUrl) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}