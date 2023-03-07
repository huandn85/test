package entity;

import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@Table(name = "file")
public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] content;
    private String type;
    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;
    public File() {
    }

    public File(int id, String name, byte[] content, String type, Product product) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.type = type;
        this.product = product;
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

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "File{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", product=" + product+
                '}';
    }
}

