package Model;

import java.util.Date;
/**
 * this class represents the customer’s format. Each object of type customer has as attributes a customer id, firstname, lastname, email, card id.It also contains a contructor, a getter and a setter for each field and a to String method.
 */

public class OrdersDetails {
    private int detail_ID;
    private int order_ID;
    private String delivery_address;
    private Date delivery_date;

    public OrdersDetails() {

    }

    public int getDetail_ID() {
        return detail_ID;
    }

    public void setDetail_ID(int detail_ID) {
        this.detail_ID = detail_ID;
    }

    public int getOrder_ID() {
        return order_ID;
    }

    public void setOrder_ID(int order_ID) {
        this.order_ID = order_ID;
    }

    public String getDelivery_address() {
        return delivery_address;
    }

    public void setDelivery_address(String delivery_address) {
        this.delivery_address = delivery_address;
    }

    public Date getDelivery_date() {
        return delivery_date;
    }

    public void setDelivery_date(Date delivery_date) {
        this.delivery_date = delivery_date;
    }

    @Override
    public String toString() {
        return "OrdersDetails{" +
                "detail_ID=" + detail_ID +
                ", order_ID=" + order_ID +
                ", delivery_address='" + delivery_address + '\'' +
                ", delivery_date=" + delivery_date +
                '}';
    }
}
