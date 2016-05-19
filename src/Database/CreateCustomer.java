package Database;

import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.Statement;

/**
 * Created by christianhasselstrom on 19/05/2016.
 */
public class CreateCustomer
{
    public static void createCustomer(TextField fname, TextField lname, TextField email, TextField zip)
    {
        String fnameStr = fname.toString();
        String lnameStr = lname.toString();
        String emailStr = email.toString();
        String zipStr = zip.toString();

        try
        {
            Connection conn = DBConnection.getConnection();
            Statement stmt = conn.createStatement();

            String sqlString = ("INSERT INTO Customer (customerFirstName, customerLastName, email, zipCode) " +
                    "VALUES ('"+fnameStr+"' , '"+lnameStr+"' , '"+emailStr+"' , '"+zipStr+"'  ) ");
            stmt.executeUpdate(sqlString);
        }
        catch (Exception e)
        {

        }
    }

}

