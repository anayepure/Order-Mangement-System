package Presentation;

import DAO.CustomerDAO;
import DAO.OrderDAO;
import DAO.OrdersDetailsDAO;
import DAO.ProductDAO;
import Model.Customer;
import Model.Orders;
import Model.OrdersDetails;
import Model.Product;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class View {
    JFrame frame = new JFrame();
    JPanel principal = new JPanel(new GridBagLayout());
    JPanel laycustomer = new JPanel();
    JTabbedPane tb=new JTabbedPane();
    JTable customers = new JTable();
    JButton viewcustomers=new JButton("View Customers");
    JButton insertcustomers=new JButton("Insert Customers");
    JButton deletecustomers=new JButton("Delete Customers");
    JButton updatecustomers=new JButton("Update Customers");
    JTextField customer_id=new JTextField("customer's id");
    JTextField firstname=new JTextField("customer's first name");
    JTextField lastname=new JTextField("customer's last name");
    JTextField email=new JTextField("customer's email");
    JTextField card_id=new JTextField("customer's card id");
    JTextField customer_del_id=new JTextField("customer's id");
    JTextField fieldwantedupdated=new JTextField("desired field");
    JTextField fieldby=new JTextField("update with field");
    JTextField newvalue=new JTextField("update with value");
    JTextField corrid=new JTextField("type which product");

    JPanel principal2 = new JPanel(new GridBagLayout());
    JPanel layproduct = new JPanel();
    JTable products = new JTable();
    JButton viewproducts=new JButton("View Products");
    JButton insertproducts=new JButton("Insert Products");
    JButton deleteproducts=new JButton("Delete Products");
    JButton updateproducts=new JButton("Update Products");
    JTextField product_id=new JTextField("product's id");
    JTextField product_name=new JTextField("product's name");
    JTextField price=new JTextField("price");
    JTextField quantity=new JTextField("quantity");
    JTextField product_del_id=new JTextField("product's id");
    JTextField fieldwantedupdated2=new JTextField("desired field");
    JTextField fieldby2=new JTextField("update with field");
    JTextField newvalue2=new JTextField("update with value");
    JTextField corrid2=new JTextField("type which client");

    JPanel principal3 = new JPanel(new GridBagLayout());
    JPanel layorder = new JPanel();
    JTable orders = new JTable();
    JButton vieworders=new JButton("View Orders");
    JButton insertorders=new JButton("Insert Order");
    JButton billorder=new JButton("Order Bill");
    JButton updateorders=new JButton("Update Order");
    JTextField order_id=new JTextField("order's id");
    JTextField customerorder_id=new JTextField("customer's id");
    JTextField productorder_id=new JTextField("product's id");
    JTextField quantity_order=new JTextField("quantity");

    JPanel principal4 = new JPanel(new GridBagLayout());
    JPanel laydetails = new JPanel();
    JTable details = new JTable();
    JButton viewdetails=new JButton("View Details");
    JButton insertdetail=new JButton("Insert Detail");
    JTextField details_id=new JTextField("details_id");
    JTextField orderdetail_id=new JTextField("order_id");
    JTextField address=new JTextField("delivery_address");

    public int getDetails_id() {
        return Integer.parseInt(details_id.getText());
    }

    public int getOrderdetail_id() {
        return Integer.parseInt(orderdetail_id.getText());
    }

    public String getAddress() {
        return address.getText();
    }

    public int getOrder_id() {
        return Integer.parseInt(order_id.getText());
    }

    public int getCustomerorder_id() {
        return Integer.parseInt(customerorder_id.getText());
    }

    public int getProductorder_id() {
        return Integer.parseInt(productorder_id.getText());
    }

    public int getQuantity_order() {
        return Integer.parseInt(quantity_order.getText());
    }

    public int getProduct_id() {
        return Integer.parseInt(product_id.getText());
    }

    public String getProduct_name() {
        return product_name.getText();
    }

    public int getPrice() {
        return Integer.parseInt(price.getText());
    }

    public int getQuantity() {
        return Integer.parseInt(quantity.getText());
    }

    public int getProduct_del_id() {
        return Integer.parseInt(product_del_id.getText());
    }

    public String getFieldwantedupdated2() {
        return fieldwantedupdated2.getText();
    }

    public String getFieldby2() {
        return fieldby2.getText();
    }

    public String getNewvalue2() {
        return newvalue2.getText();
    }

    public int getCorrid2() {
        return Integer.parseInt(corrid2.getText());
    }

    public int getCustomer_id() {
        return Integer.parseInt(customer_id.getText());
    }

    public String getFirstname() {
        return firstname.getText();
    }

    public String getLastname() {
        return lastname.getText();
    }

    public String getEmail() {
        return email.getText();
    }

    public int getCard_id() {
        return Integer.parseInt(card_id.getText());
    }

    public int getCustomer_del_id() {
        return Integer.parseInt(customer_del_id.getText());
    }

    public String getFieldwantedupdated() {
        return fieldwantedupdated.getText();
    }

    public String getFieldby() {
        return fieldby.getText();
    }

    public String getNewvalue() {
        return newvalue.getText();
    }

    public int getCorrid() {
        return Integer.parseInt(corrid.getText());
    }

    public View()
    {
        //customers
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(11, 6, 6, 6);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 50;
        gbc.weightx = 0.0;
        gbc.gridwidth = 5;
        gbc.gridx = 0;
        gbc.gridy = 0;
        laycustomer.setBorder(BorderFactory.createTitledBorder("Customers info"));
        BoxLayout lay1 = new BoxLayout(laycustomer, BoxLayout.Y_AXIS);
        laycustomer.setLayout(lay1);
        customers.setPreferredScrollableViewportSize(new Dimension(500, 60));
        customers.setFillsViewportHeight(true);
        JScrollPane scroll=new JScrollPane(customers);
        laycustomer.add(scroll);
        principal.add(laycustomer, gbc);
        gbc.insets = new Insets(11, 6, 6, 6);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 0;
        gbc.weighty = 1.0;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        gbc.gridy = 1;
        principal.add(viewcustomers,gbc);
        gbc.insets = new Insets(11, 6, 6, 6);
        //gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 0;
        gbc.weighty = 1.0;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        gbc.gridy = 2;
        principal.add(insertcustomers,gbc);
        gbc.insets = new Insets(11, 6, 6, 6);
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.gridx = 2;
        gbc.gridy = 2;
        principal.add(customer_id,gbc);
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.insets = new Insets(11, 6, 6, 20);
        gbc.gridx = 3;
        gbc.gridy = 2;
        principal.add(firstname,gbc);
        gbc.insets = new Insets(11, 60, 6, 6);
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.gridx = 4;
        gbc.gridy = 2;
        principal.add(lastname,gbc);
        gbc.insets = new Insets(11, 60, 6, 6);
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.gridx = 5;
        gbc.gridy = 2;
        principal.add(email,gbc);
        gbc.insets = new Insets(11, 60, 6, 6);
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.gridx = 6;
        gbc.gridy = 2;
        principal.add(card_id,gbc);
        gbc.insets = new Insets(11, 6, 6, 6);
        //gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 0;
        gbc.weighty = 1.0;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        gbc.gridy = 3;
        principal.add(deletecustomers,gbc);
        gbc.insets = new Insets(11, 6, 6, 6);
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.gridx = 2;
        gbc.gridy = 3;
        principal.add(customer_del_id,gbc);
        gbc.insets = new Insets(11, 6, 6, 6);
        //gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 0;
        gbc.weighty = 1.0;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        gbc.gridy = 4;
        gbc.insets = new Insets(11, 6, 6, 6);
        principal.add(updatecustomers,gbc);
        gbc.insets = new Insets(11, 3, 6, 3);
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.gridx = 2;
        gbc.gridy = 4;
        principal.add(fieldwantedupdated,gbc);
        gbc.insets = new Insets(11, 6, 6, 20);
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.gridx = 3;
        gbc.gridy = 4;
        principal.add(fieldby,gbc);
        gbc.insets = new Insets(11, 60, 6, 6);
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.gridx = 4;
        gbc.gridy = 4;
        principal.add(newvalue,gbc);
        gbc.insets = new Insets(11, 60, 6, 6);
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.gridx = 5;
        gbc.gridy = 4;
        principal.add(corrid,gbc);

        //products
        gbc.insets = new Insets(11, 6, 6, 6);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 50;
        gbc.weightx = 0.0;
        gbc.gridwidth = 5;
        gbc.gridx = 0;
        gbc.gridy = 0;
        layproduct.setBorder(BorderFactory.createTitledBorder("Products info"));
        BoxLayout lay2 = new BoxLayout(layproduct, BoxLayout.Y_AXIS);
        layproduct.setLayout(lay2);
        products.setPreferredScrollableViewportSize(new Dimension(500, 60));
        products.setFillsViewportHeight(true);
        JScrollPane scroll2=new JScrollPane(products);
        layproduct.add(scroll2);
        principal2.add(layproduct, gbc);
        gbc.insets = new Insets(11, 6, 6, 6);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 0;
        gbc.weighty = 1.0;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        gbc.gridy = 1;
        principal2.add(viewproducts,gbc);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 0;
        gbc.weighty = 1.0;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        gbc.gridy = 2;
        principal2.add(insertproducts,gbc);
        gbc.insets = new Insets(11, 6, 6, 6);
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.gridx = 2;
        gbc.gridy = 2;
        principal2.add(product_id,gbc);
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.insets = new Insets(11, 6, 6, 20);
        gbc.gridx = 3;
        gbc.gridy = 2;
        principal2.add(product_name,gbc);
        gbc.insets = new Insets(11, 60, 6, 6);
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.gridx = 4;
        gbc.gridy = 2;
        principal2.add(price,gbc);
        gbc.insets = new Insets(11, 60, 6, 6);
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.gridx = 5;
        gbc.gridy = 2;
        principal2.add(quantity,gbc);
        gbc.insets = new Insets(11, 6, 6, 6);
        //gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 0;
        gbc.weighty = 1.0;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        gbc.gridy = 3;
        principal2.add(deleteproducts,gbc);
        gbc.insets = new Insets(11, 6, 6, 6);
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.gridx = 2;
        gbc.gridy = 3;
        principal2.add(product_del_id,gbc);
        gbc.insets = new Insets(11, 6, 6, 6);
        //gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 0;
        gbc.weighty = 1.0;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        gbc.gridy = 4;
        principal2.add(updateproducts,gbc);
        gbc.insets = new Insets(11, 3, 6, 3);
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.gridx = 2;
        gbc.gridy = 4;
        principal2.add(fieldwantedupdated2,gbc);
        gbc.insets = new Insets(11, 6, 6, 20);
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.gridx = 3;
        gbc.gridy = 4;
        principal2.add(fieldby2,gbc);
        gbc.insets = new Insets(11, 60, 6, 6);
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.gridx = 4;
        gbc.gridy = 4;
        principal2.add(newvalue2,gbc);
        gbc.insets = new Insets(11, 60, 6, 6);
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.gridx = 5;
        gbc.gridy = 4;
        principal2.add(corrid2,gbc);

        //orders
        gbc.insets = new Insets(11, 6, 6, 6);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 50;
        gbc.weightx = 0.0;
        gbc.gridwidth = 5;
        gbc.gridx = 0;
        gbc.gridy = 0;
        layorder.setBorder(BorderFactory.createTitledBorder("Orders info"));
        BoxLayout lay3 = new BoxLayout(layorder, BoxLayout.Y_AXIS);
        layorder.setLayout(lay3);
        orders.setPreferredScrollableViewportSize(new Dimension(500, 60));
        orders.setFillsViewportHeight(true);
        JScrollPane scroll3=new JScrollPane(orders);
        layorder.add(scroll3);
        principal3.add(layorder, gbc);
        gbc.insets = new Insets(11, 6, 6, 6);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 0;
        gbc.weighty = 1.0;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        gbc.gridy = 1;
        principal3.add(vieworders,gbc);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 0;
        gbc.weighty = 1.0;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        gbc.gridy = 2;
        principal3.add(insertorders,gbc);
        gbc.insets = new Insets(11, 6, 6, 6);
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.gridx = 2;
        gbc.gridy = 2;
        principal3.add(order_id,gbc);
        gbc.insets = new Insets(11, 6, 6, 20);
        gbc.gridx = 3;
        gbc.gridy = 2;
        principal3.add(customerorder_id,gbc);
        gbc.insets = new Insets(11, 60, 6, 6);
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.gridx = 4;
        gbc.gridy = 2;
        principal3.add(productorder_id,gbc);
        gbc.insets = new Insets(11, 60, 6, 6);
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.gridx = 5;
        gbc.gridy = 2;
        principal3.add(quantity_order,gbc);
        gbc.insets = new Insets(11, 6, 6, 6);
        //gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 0;
        gbc.weighty = 1.0;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        gbc.gridy = 3;
        principal3.add(billorder,gbc);
        //ordersdetails
        gbc.insets = new Insets(11, 6, 6, 6);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 50;
        gbc.weightx = 0.0;
        gbc.gridwidth = 5;
        gbc.gridx = 0;
        gbc.gridy = 0;
        laydetails.setBorder(BorderFactory.createTitledBorder("Details info"));
        BoxLayout lay4 = new BoxLayout(laydetails, BoxLayout.Y_AXIS);
        laydetails.setLayout(lay4);
        details.setPreferredScrollableViewportSize(new Dimension(500, 60));
        details.setFillsViewportHeight(true);
        JScrollPane scroll4=new JScrollPane(details);
        laydetails.add(scroll4);
        principal4.add(laydetails, gbc);
        gbc.insets = new Insets(11, 6, 6, 6);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 0;
        gbc.weighty = 1.0;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        gbc.gridy = 1;
        principal4.add(viewdetails,gbc);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 0;
        gbc.weighty = 1.0;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        gbc.gridy = 2;
        principal4.add(insertdetail,gbc);
        gbc.insets = new Insets(11, 6, 6, 6);
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.gridx = 2;
        gbc.gridy = 2;
        principal4.add(details_id,gbc);
        gbc.insets = new Insets(11, 6, 6, 20);
        gbc.gridx = 3;
        gbc.gridy = 2;
        principal4.add(orderdetail_id,gbc);
        gbc.insets = new Insets(11, 60, 6, 6);
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.gridx = 4;
        gbc.gridy = 2;
        principal4.add(address,gbc);

        tb.setBounds(700,700,700,700);
        tb.addTab("Customers", principal);
        tb.addTab("Products",principal2);
        tb.addTab("Orders",principal3);
        tb.addTab("Details",principal4);
        tb.setMnemonicAt(0, KeyEvent.VK_1);
        frame.add(tb);
        frame.pack();
        frame.setVisible(true);
    }

    public void tabledataCustomer(CustomerDAO custom) throws SQLException {
        List<Customer> lista =new ArrayList<Customer>();
        lista=custom.findall();
        String[] columns = new String[] {
                "customer_ID", "firstname", "lastname", "email","card_id"
        };
        DefaultTableModel tabel = new DefaultTableModel();
        tabel.setColumnIdentifiers(columns);

        for (Customer customer:lista)
        {
            int length=columns.length;
            Object[] data = new Object[length];
            data[0]=customer.getCustomer_ID();
            data[1]=customer.getFirstname();
            data[2]=customer.getLastname();
            data[3]=customer.getEmail();
            data[4]=customer.getCard_id();
            tabel.addRow(data);


        }
        customers.setModel(tabel);
    }

    public void tabledataProduct(ProductDAO product) throws SQLException {
        List<Product> lista =new ArrayList<Product>();
        lista=product.findall();
        String[] columns = new String[] {
                "product_ID", "product_name", "price", "quantity"
        };
        DefaultTableModel tabel = new DefaultTableModel();
        tabel.setColumnIdentifiers(columns);

        for (Product produs:lista)
        {
            int length=columns.length;
            Object[] data = new Object[length];
            data[0]=produs.getProduct_ID();
            data[1]=produs.getProduct_name();
            data[2]=produs.getPrice();
            data[3]=produs.getQuantity();
            tabel.addRow(data);


        }
        products.setModel(tabel);
    }

    public void tabledataOrders(OrderDAO order) throws SQLException {
        List<Orders> lista =new ArrayList<Orders>();
        lista=order.findall();
        String[] columns = new String[] {
                "order_ID", "customer_ID", "product_ID", "quantity","total"
        };
        DefaultTableModel tabel = new DefaultTableModel();
        tabel.setColumnIdentifiers(columns);

        for (Orders comanda:lista)
        {
            int length=columns.length;
            Object[] data = new Object[length];
            data[0]=comanda.getOrder_ID();
            data[1]=comanda.getCustomer_ID();
            data[2]=comanda.getProduct_ID();
            data[3]=comanda.getQuantity();
            data[4]=comanda.getTotal();
            tabel.addRow(data);


        }
        orders.setModel(tabel);
    }

    public void tabledataDetails(OrdersDetailsDAO detalii) throws SQLException {
        List<OrdersDetails> lista =new ArrayList<OrdersDetails>();
        lista=detalii.findall();
        String[] columns = new String[] {
                "details_ID", "order_ID", "delivery_address", "delivery_date"
        };
        DefaultTableModel tabel = new DefaultTableModel();
        tabel.setColumnIdentifiers(columns);

        for (OrdersDetails detaliu:lista)
        {
            int length=columns.length;
            Object[] data = new Object[length];
            data[0]=detaliu.getDetail_ID();
            data[1]=detaliu.getOrder_ID();
            data[2]=detaliu.getDelivery_address();
            data[3]=detaliu.getDelivery_date();
            tabel.addRow(data);


        }
        details.setModel(tabel);
    }

    public void addViewListener(ActionListener view)
    {
        viewcustomers.addActionListener(view);
    }
    public void addInsertListener(ActionListener insert)
    {
        insertcustomers.addActionListener(insert);
    }

    public void addDeleteListener(ActionListener delete)
    {
        deletecustomers.addActionListener(delete);
    }
    public void addUpdateListener(ActionListener update)
    {
        updatecustomers.addActionListener(update);
    }

    public void addViewListener2(ActionListener view)
    {
        viewproducts.addActionListener(view);
    }

    public void addInsertListener2(ActionListener insert)
    {
        insertproducts.addActionListener(insert);
    }
    public void addDeleteListener2(ActionListener delete)
    {
        deleteproducts.addActionListener(delete);
    }

    public void addUpdateListener2(ActionListener update)
    {
        updateproducts.addActionListener(update);
    }

    public void addViewListener3(ActionListener view)
    {
        vieworders.addActionListener(view);
    }

    public void addInsertListener3(ActionListener insert)
    {
        insertorders.addActionListener(insert);
    }

    public void addBillListener(ActionListener insert)
    {
        billorder.addActionListener(insert);
    }

    public void addViewListener4(ActionListener view)
    {
        viewdetails.addActionListener(view);
    }

    public void addInsertListener4(ActionListener view)
    {
        insertdetail.addActionListener(view);
    }





}