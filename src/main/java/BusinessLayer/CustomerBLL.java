package BusinessLayer;

import Model.Customer;

import javax.xml.validation.Validator;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class CustomerBLL{

    public CustomerBLL()
    {

    }

    public boolean validCustomer(Customer custom)
    {
          if (validateName(custom.getFirstname())==false) return false;
          if (validateEmail(custom.getEmail())==false) return false;
          if (validateCardId(custom.getCard_id())==false) return false;
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

    public boolean validateEmail(String email)
    {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        Pattern p = Pattern.compile(regex);
        Matcher match=p.matcher(email);
        if (match.matches()) return true;
        else return false;
    }

    public boolean validateCardId(int card)
    {
        if (card<10000 || card>99999) return false;
        return true;
    }

}
