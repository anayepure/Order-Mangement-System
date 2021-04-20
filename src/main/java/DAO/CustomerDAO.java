package DAO;

import Model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO extends AbstractDAO<Customer> {

    public Customer findbyID(int id,String field)
    {
        return super.findbyID(id,field);
    }

    public List<Customer> findall() throws SQLException {
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

   public void insert(Customer a)
   {
       String query="INSERT INTO customer VALUES (?,?,?,?,?)";
       Connection conn=null;
       PreparedStatement statement=null;

       try
       {
           conn=ConnectionFactory.getConnection();
           statement= conn.prepareStatement(query);
           statement.setInt(1,a.getCustomer_ID());
           statement.setString(2,a.getFirstname());
           statement.setString(3,a.getLastname());
           statement.setString(4,a.getEmail());
           statement.setInt(5,a.getCard_id());
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
