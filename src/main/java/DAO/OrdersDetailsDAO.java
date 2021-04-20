package DAO;

import Model.Orders;
import Model.OrdersDetails;
import Model.Product;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class OrdersDetailsDAO extends AbstractDAO<OrdersDetails> {
    public OrdersDetails findbyID(int id, String field)
    {
        return super.findbyID(id,field);
    }

    public List<OrdersDetails> findall() throws SQLException {
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

    public void update2(String field1, String field2,int intr,int id)
    {
        super.update2(field1,field2,intr,id);
    }

    public void insert(OrdersDetails orderdetail,int id)
    {
        orderdetail.setOrder_ID(id);
        String query="INSERT INTO ordersdetails VALUES (?,?,?,?)";
        Connection conn=null;
        PreparedStatement statement=null;
        LocalDate data=java.time.LocalDate.now();
        try
        {
            conn=ConnectionFactory.getConnection();
            statement= conn.prepareStatement(query);
            statement.setInt(1,orderdetail.getDetail_ID());
            statement.setInt(2,orderdetail.getOrder_ID());
            statement.setString(3,orderdetail.getDelivery_address());
            statement.setDate(4, Date.valueOf(data));
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
