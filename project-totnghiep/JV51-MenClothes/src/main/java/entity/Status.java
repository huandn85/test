package entity;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "status")
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToMany(mappedBy = "statusId")
    private List<Order> listOrderStatus;
    @OneToMany(mappedBy = "status")
    private List<Product> productList;
    public Status() {
    }

    public Status(int id, String name, List<Order> listOrderStatus, List<Product> productList) {
        this.id = id;
        this.name = name;
        this.listOrderStatus = listOrderStatus;
        this.productList = productList;
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

    public List<Order> getListOrderStatus() {
        return listOrderStatus;
    }

    public void setListOrderStatus(List<Order> listOrderStatus) {
        this.listOrderStatus = listOrderStatus;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}

