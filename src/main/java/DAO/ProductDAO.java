package DAO;

import Model.Customer;
import Model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ProductDAO extends AbstractDAO<Product> {
    public Product findbyID(int id, String field)
    {
        return super.findbyID(id,field);
    }

    public List<Product> findall() throws SQLException {
        return super.findall();
    }

    public void delete(int id,String field)
    {
        super.delete(id,field);
    }

    public void update(String field1, String field2,String intr,int id)
    {
        super.update(field1,field2,intr,id);
    }

    public void insert(Product a)
    {
        String query="INSERT INTO product VALUES (?,?,?,?)";
        Connection conn=null;
        PreparedStatement statement=null;

        try
        {
            conn=ConnectionFactory.getConnection();
            statement= conn.prepareStatement(query);
            statement.setInt(1,a.getProduct_ID());
            statement.setString(2,a.getProduct_name());
            statement.setInt(3,a.getPrice());
            statement.setInt(4,a.getQuantity());
            statement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(conn);
        }
    }

}
