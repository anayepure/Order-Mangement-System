package Model;
/**
 * this class represents the customer’s format. Each object of type customer has as attributes a customer id, firstname, lastname, email, card id.It also contains a contructor, a getter and a setter for each field and a to String method.
 */

public class Orders {
    private int order_ID;
    private int customer_ID;
    private int product_ID;
    private int quantity;
    private int total;

    public Orders() {

    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getOrder_ID() {
        return order_ID;
    }

    public void setOrder_ID(int order_ID) {
        this.order_ID = order_ID;
    }

    public int getCustomer_ID() {
        return customer_ID;
    }

    public void setCustomer_ID(int customer_ID) {
        this.customer_ID = customer_ID;
    }

    public int getProduct_ID() {
        return product_ID;
    }

    public void setProduct_ID(int product_ID) {
        this.product_ID = product_ID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "order_ID=" + order_ID +
                ", customer_ID=" + customer_ID +
                ", product_ID=" + product_ID +
                ", quantity=" + quantity +
                ", total=" + total +
                '}';
    }
}
