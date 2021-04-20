package BusinessLayer;

import Model.Product;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProductBLL {
    public ProductBLL()
    {

    }

    public boolean validProduct(Product product)
    {
        if (validateName(product.getProduct_name())==false) return false;
        if (validatePrice(product.getPrice())==false) return false;
        if (validateQuantity(product.getQuantity())==false) return false;
        else return true;

    }

    public boolean validateName(String name)
    {
        String regex="^[a-zA-Z\\s]+";
        Pattern p = Pattern.compile(regex);
        Matcher match=p.matcher(name);
        if (match.matches()) return true;
        else return false;
    }

    public boolean validatePrice(int price)
    {
        if (price<0) return false;
        else return true;
    }

    public boolean validateQuantity(int price)
    {
        if (price<0) return false;
        else return true;
    }

}
