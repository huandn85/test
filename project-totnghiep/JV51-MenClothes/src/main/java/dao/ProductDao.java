package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import entity.Product;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class ProductDao {
    JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }
    public List<Product> getProductByPage(int pageid,int total){
        String sql="select * from product limit "+(pageid-1)+","+total;
        return template.query(sql,new RowMapper<Product>(){
            public Product mapRow(ResultSet rs, int row) throws SQLException {
                Product e =new Product();
                e.setId(rs.getInt(1));
                e.setName(rs.getString(2));
                e.setImportPrice(rs.getFloat(4));
                e.setPrice(rs.getFloat(5));
                e.setQuantitys(rs.getInt(8));
                return e;
            }
        });
    }
}