package Model;
/**
 * this class represents the customer’s format. Each object of type customer has as attributes a customer id, firstname, lastname, email, card id.It also contains a contructor, a getter and a setter for each field and a to String method.
 */
public class Customer {
    private int customer_ID;
    private String firstname;
    private String lastname;
    private String email;
    private int card_id;

    public Customer() {

    }

    public int getCustomer_ID() {
        return customer_ID;
    }

    public void setCustomer_ID(int customer_ID) {
        this.customer_ID = customer_ID;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCard_id() {
        return card_id;
    }

    public void setCard_id(int card_id) {
        this.card_id = card_id;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customer_ID=" + customer_ID +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", card_id=" + card_id +
                '}';
    }
}
