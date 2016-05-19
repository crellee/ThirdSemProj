package Database;

import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by christianhasselstrom on 19/05/2016.
 */
public class CreateCustomer
{
    static TextField emailField;

    public static boolean createCustomer(TextField fname, TextField lname, TextField email, TextField zip) {
        String fnameStr = fname.getText().toString();
        String lnameStr = lname.getText().toString();
        String emailStr = email.getText().toString();
        int zipInt = Integer.parseInt(zip.getText().toString());
        boolean succesfull = false;

        try {
            Connection conn = DBConnection.getConnection();
            Statement stmt = conn.createStatement();

            String sqlString = ("INSERT INTO Customer (customerFirstName, customerLastName, email, zipCode) " +
                    "VALUES ('" + fnameStr + "' , '" + lnameStr + "' , '" + emailStr + "' , '" + zipInt + "'  ) ");
            stmt.executeUpdate(sqlString);
            succesfull = true;
            emailField = email;

        } catch (Exception e) {

        }
        return succesfull;
    }

    public static int getCustomerId(TextField email) {
        int id = 0;
        String emailStr = email.getText().toString();
        try {
            Connection conn = DBConnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs;


            String sqlString = ("SELECT * FROM Customer WHERE email = '" + emailStr + "' ");
            rs = stmt.executeQuery(sqlString);

            id = rs.getInt("customerId");


        } catch (Exception e) {

        }
        return id;
    }

    public static void createImercoCard(TextField imercoCard)
    {
        int imercoCardInt = Integer.parseInt(imercoCard.getText().toString());
        int imercoPoints = 0;
        int customerId = getCustomerId(emailField);


        try
        {
            Connection conn = DBConnection.getConnection();
            Statement stmt = conn.createStatement();

            String sqlString = ("INSERT INTO ImercoCard (imercoCardId, customerId, point) " +
                    "VALUES ('" + imercoCardInt + "' , '" + customerId + "' , '" + imercoPoints + "'  ) ");
            stmt.execute(sqlString);
        }
        catch (Exception e)
        {
        }
    }

}

