package Main;
import BusinessLayer.CustomerBLL;
import BusinessLayer.ProductBLL;
import DAO.*;
import Model.Customer;
import Model.Orders;
import Model.OrdersDetails;
import Model.Product;
import Presentation.Controller;
import Presentation.View;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main  {

    public static void main(String args[]) throws SQLException {
        CustomerDAO custom=new CustomerDAO();
        List<Customer>lista =new ArrayList<Customer>();
        lista=custom.findall();
        View v=new View();
        Controller c=new Controller(v);
        //custom.update("firstname","customer_ID","Carolina",2);
        OrderDAO o=new OrderDAO();
        o.findall();
    }
}


