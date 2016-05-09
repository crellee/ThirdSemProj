package Database;

import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by roije on 09/05/2016.
 */
public class EmployeeLoginVerifier
{
    static String email;

    public boolean verifyUser (TextField empNumField)
    {

        boolean verified = false;
        String employeeNumber = empNumField.getText();

        try
        {
            Connection conn = DBConnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs;

            if(empNumField != null)
            {
                String sqlString = "SELECT * FROM Employee WHERE employeeId = '"+employeeNumber+"'";
                rs = stmt.executeQuery(sqlString);

                if(rs.next())
                {
                    verified = true;
                }
            }

        }
        catch(SQLException e)
        {

        }
        return verified;

    }

    //Set email variable to email in GUI TextField. Used when user is logging in to get the right user.
    public static void setEmail(TextField emailFromGui)
    {
        String emailStr = emailFromGui.getText();
        email = emailStr;
    }

    public static String getEmail()
    {
        return email;
    }

}
