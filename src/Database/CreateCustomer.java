package Database;

import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.Statement;

/**
 * Created by christianhasselstrom on 19/05/2016.
 */
public class CreateCustomer
{
    public static boolean createCustomer(TextField fname, TextField lname, TextField email, TextField zip)
    {
        String fnameStr = fname.getText().toString();
        String lnameStr = lname.getText().toString();
        String emailStr = email.getText().toString();
        int zipInt = Integer.parseInt(zip.getText().toString());
        boolean succesfull = false;

        try
        {
            Connection conn = DBConnection.getConnection();
            Statement stmt = conn.createStatement();

            String sqlString = ("INSERT INTO Customer (customerFirstName, customerLastName, email, zipCode) " +
                    "VALUES ('"+fnameStr+"' , '"+lnameStr+"' , '"+emailStr+"' , '"+zipInt+"'  ) ");
            stmt.executeUpdate(sqlString);
            succesfull = true;

        }
        catch (Exception e)
        {

        }
        return succesfull;
    }

    public static void getCustomerId(TextField email)
    {
        String emailStr = email.getText().toString();
        try
        {
            Connection conn = DBConnection.getConnection();
            Statement stmt = conn.createStatement();

            String sqlString = ("SELECT CustomerId FROM Customer WHERE email = '"+emailStr+"' ");

        }
    }

}

