package Presentation;

import BusinessLayer.CustomerBLL;
import BusinessLayer.OrdersDetailsBLL;
import BusinessLayer.ProductBLL;
import DAO.CustomerDAO;
import DAO.OrderDAO;
import DAO.OrdersDetailsDAO;
import DAO.ProductDAO;
import Model.Customer;
import Model.Orders;
import Model.OrdersDetails;
import Model.Product;
import com.mysql.cj.x.protobuf.MysqlxCrud;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Controller {
  private View view;
  public Controller(View view)
  {
    this.view=view;
    view.addViewListener(new ViewListener());
    view.addInsertListener(new InsertListener());
    view.addDeleteListener(new DeleteListener());
    view.addUpdateListener(new UpdateListener());
    view.addViewListener2(new ViewListener2());
    view.addInsertListener2(new InsertListener2());
    view.addDeleteListener2(new DeleteListener2());
    view.addUpdateListener2(new UpdateListener2());
    view.addViewListener3(new ViewListener3());
    view.addInsertListener3(new InsertListener3());
    view.addBillListener(new BillListener());
    view.addViewListener4(new ViewListener4());
    view.addInsertListener4(new InsertListener4());

  }

  public class ViewListener implements ActionListener
  {

      @Override
      public void actionPerformed(ActionEvent e) {
          CustomerDAO customer=new CustomerDAO();
          try {
              view.tabledataCustomer(customer);
          } catch (SQLException throwables) {
              throwables.printStackTrace();
          }

      }
  }

  public class InsertListener implements ActionListener
  {

      @Override
      public void actionPerformed(ActionEvent e) {
       Customer custom=new Customer();
       custom.setCustomer_ID(view.getCustomer_id());
       custom.setFirstname(view.getFirstname());
       custom.setLastname(view.getLastname());
       custom.setEmail(view.getEmail());
       custom.setCard_id(view.getCard_id());

       CustomerDAO c=new CustomerDAO();
       CustomerBLL b=new CustomerBLL();

       if (b.validCustomer(custom)==true) c.insert(custom);
       JOptionPane.showMessageDialog(view.frame, "Inserted Customer!:)");


      }
  }

    public class DeleteListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {

            CustomerDAO c=new CustomerDAO();
            c.delete(view.getCustomer_del_id(),"customer_ID");
            JOptionPane.showMessageDialog(view.frame, "Deleted Customer!:)");
        }
    }

    public class UpdateListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {

            CustomerDAO c=new CustomerDAO();
           c.update(view.getFieldwantedupdated(),view.getFieldby(),view.getNewvalue(),view.getCorrid());
            JOptionPane.showMessageDialog(view.frame, "Updated Customer!:)");
        }
    }

    public class ViewListener2 implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            ProductDAO product=new ProductDAO();
            try {
                view.tabledataProduct(product);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
    }

    public class InsertListener2 implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            Product product=new Product();
            product.setProduct_ID(view.getProduct_id());
            product.setProduct_name(view.getProduct_name());
            product.setPrice(view.getPrice());
            product.setQuantity(view.getQuantity());

            ProductDAO p=new ProductDAO();
            ProductBLL b=new ProductBLL();

            if (b.validProduct(product)==true) p.insert(product);
            JOptionPane.showMessageDialog(view.frame, "Inserted Product!:)");
        }
    }

    public class DeleteListener2 implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {

            ProductDAO c=new ProductDAO();
            c.delete(view.getProduct_del_id(),"product_ID");
            JOptionPane.showMessageDialog(view.frame, "Deleted Customer!:)");
        }
    }

    public class UpdateListener2 implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {

            ProductDAO c=new ProductDAO();
            c.update(view.getFieldwantedupdated2(),view.getFieldby2(),view.getNewvalue2(),view.getCorrid2());
            JOptionPane.showMessageDialog(view.frame, "Updated Product!:)");
        }
    }

    public class ViewListener3 implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            OrderDAO order=new OrderDAO();
            try {
                view.tabledataOrders(order);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
    }

    public class InsertListener3 implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            Orders order=new Orders();
            order.setOrder_ID(view.getOrder_id());
            order.setCustomer_ID(view.getCustomerorder_id());
            order.setProduct_ID(view.getProductorder_id());
            order.setQuantity(view.getQuantity_order());

            OrderDAO p=new OrderDAO();
            p.insert(order,view.getOrder_id(),view.getProductorder_id(),view.getQuantity_order());
            JOptionPane.showMessageDialog(view.frame, "Inserted Order!:)");
        }
    }

    public class BillListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                PrintWriter out = new PrintWriter("bill.txt");
                out.println("Order's id: " + view.getOrder_id() );
                out.println("Customer's id: " + view.getCustomerorder_id());
                out.println("Product's id: " + view.getProductorder_id());
                out.println("Quantity: " + view.getQuantity_order());
                OrderDAO order=new OrderDAO();
                Orders o=new Orders();
                o=order.findbyID(view.getOrder_id(),"order_ID");
                out.println("Total: " + o.getTotal());
                out.close();
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
        }
    }

    public class ViewListener4 implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            OrdersDetailsDAO detalii=new OrdersDetailsDAO();
            try {
                view.tabledataDetails(detalii);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
    }

    public class InsertListener4 implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            OrdersDetails detaliu=new OrdersDetails();
            detaliu.setDetail_ID(view.getDetails_id());
            detaliu.setOrder_ID(view.getOrderdetail_id());
            detaliu.setDelivery_address(view.getAddress());

            OrdersDetailsDAO p=new OrdersDetailsDAO();
            OrdersDetailsBLL b=new OrdersDetailsBLL();

            if (b.validOrdersDetails(detaliu)==true) p.insert(detaliu,view.getOrderdetail_id());
            JOptionPane.showMessageDialog(view.frame, "Inserted Detail!:)");
        }
    }



}
