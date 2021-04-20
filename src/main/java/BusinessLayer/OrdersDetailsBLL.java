package BusinessLayer;

import Model.OrdersDetails;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OrdersDetailsBLL {
    public OrdersDetailsBLL()
    {

    }

    public boolean validOrdersDetails(OrdersDetails detalii)
    {
        if (validateAddress(detalii.getDelivery_address())==false) return false;
        else return true;
    }

    public boolean validateAddress(String adresa)
    {
        String regex="^[a-zA-Z\\s]+";
        Pattern p = Pattern.compile(regex);
        Matcher match=p.matcher(adresa);
        if (match.matches()) return true;
        else return false;
    }
}
