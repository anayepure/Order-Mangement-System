package DAO;

import Model.Customer;
import Model.Orders;
import Model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class OrderDAO extends AbstractDAO<Orders>{
    public Orders findbyID(int id, String field)
    {
        return super.findbyID(id,field);
    }

    public List<Orders> findall() throws SQLException {
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

    public void insert(Orders order,int customer_id,int product_id,int quant)
    {
        order.setCustomer_ID(customer_id);
        order.setProduct_ID(product_id);
        ProductDAO produs=new ProductDAO();
        Product cantitate=produs.findbyID(product_id,"product_ID");
        if (cantitate.getQuantity()==0) System.out.println("We ran out of that! :(");
        else if (cantitate.getQuantity()<quant) System.out.println("We don't have enough of that! :(");
        else {
            produs.update2("quantity", "product_ID", cantitate.getQuantity() - quant, product_id);
            order.setTotal(cantitate.getPrice());
        }

        order.setQuantity(quant);
        String query="INSERT INTO orders VALUES (?,?,?,?,?)";
        Connection conn=null;
        PreparedStatement statement=null;

        try
        {
            conn=ConnectionFactory.getConnection();
            statement= conn.prepareStatement(query);
            statement.setInt(1,order.getOrder_ID());
            statement.setInt(2,order.getCustomer_ID());
            statement.setInt(3,order.getProduct_ID());
            statement.setInt(4,order.getQuantity());
            statement.setInt(5,order.getTotal());
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
