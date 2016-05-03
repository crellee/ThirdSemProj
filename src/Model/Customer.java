package Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kristinOlof on 03-05-2016.
 */
public class Customer
{
    private String firstName;
    private String lastName;
    private int zipCode;
    private String email;

    public static List<Customer> customerList = new ArrayList<Customer>();

    public Customer()
    {}

    public Customer(String firstName, String lastName, int zipCode, String email)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.zipCode = zipCode;
        this.email = email;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public int getZipCode()
    {
        return zipCode;
    }

    public String getEmail()
    {
        return email;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public void setZipCode(int zipCode)
    {
        this.zipCode = zipCode;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }
}
