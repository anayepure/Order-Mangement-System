package Model;
/**
 * this class represents the customer’s format. Each object of type customer has as attributes a customer id, firstname, lastname, email, card id.It also contains a contructor, a getter and a setter for each field and a to String method.
 */

public class Product {
    /**
     * @param product_ID product's id
     * @param product_name product's name
     * @param products price
     * @param products quantity
     */
    private int product_ID;
    private String product_name;
    private int price;
    private int quantity;

    public Product() {

    }

    public int getProduct_ID() {
        return product_ID;
    }

    public void setProduct_ID(int product_ID) {
        this.product_ID = product_ID;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "product_ID=" + product_ID +
                ", product_name='" + product_name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
