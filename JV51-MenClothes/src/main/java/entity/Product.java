package entity;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String name;
    @ManyToOne
    @JoinColumn(name = "categoryId")
    @NotNull(message = "is required")
    private Category categoryId;
    @NotNull(message = "is required")
    private float importPrice;
    @NotNull(message = "is required")
    private float price;
    private String descriptions;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "is required")
    private LocalDate dates;
    @NotNull(message = "is required")
    private int quantitys;
    @OneToMany(mappedBy = "product")
    private List<File> imageProductList;
    @OneToMany(mappedBy = "productId")
    @NotNull(message = "is required")
    private List<ProductSizeColor> productSizeColorList;
    @ManyToOne
    @JoinColumn(name = "statusId")
    @NotNull(message = "is required")
    private Status status;
    public Product() {
    }

    public Product(int id, String name, Category categoryId, float importPrice, float price, String descriptions, LocalDate dates, int quantitys, List<File> imageProductList, List<ProductSizeColor> productSizeColorList, Status status) {
        this.id = id;
        this.name = name;
        this.categoryId = categoryId;
        this.importPrice = importPrice;
        this.price = price;
        this.descriptions = descriptions;
        this.dates = dates;
        this.quantitys = quantitys;
        this.imageProductList = imageProductList;
        this.productSizeColorList = productSizeColorList;
        this.status = status;
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

    public Category getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Category categoryId) {
        this.categoryId = categoryId;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public LocalDate getDates() {
        return dates;
    }

    public void setDates(LocalDate dates) {
        this.dates = dates;
    }

    public int getQuantitys() {
        return quantitys;
    }

    public void setQuantitys(int quantitys) {
        this.quantitys = quantitys;
    }

    public List<File> getImageProductList() {
        return imageProductList;
    }

    public void setImageProductList(List<File> imageProductList) {
        this.imageProductList = imageProductList;
    }

    public List<ProductSizeColor> getProductSizeColorList() {
        return productSizeColorList;
    }

    public void setProductSizeColorList(List<ProductSizeColor> productSizeColorList) {
        this.productSizeColorList = productSizeColorList;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
