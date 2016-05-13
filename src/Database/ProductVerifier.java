package Database;

import GUI.GUI_Controller.HomePage_Controller;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by christianhasselstrom on 12/05/2016.
 */
public class ProductVerifier
{
    /*
    public static void verifyProduct(TextField str)
    {
        String productStr = str.getText().toString();

        try
        {
            Connection conn = DBConnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs;

            if(productStr != null)
            {
                String sqlString = "SELECT * FROM Imerco_Project.Products WHERE productId = '"+productStr+"' ";
                rs = stmt.executeQuery(sqlString);
                if(rs.next())
                {
                    HomePage_Controller.addToTable2();
                }
            }

        }
        catch (Exception e)
        {

        }
    }
    */
    public static ResultSet tableShow(TextField str)
    {
        String productStr = str.getText().toString();
        ResultSet rs = null;
        try
        {
            Connection conn = DBConnection.getConnection();
            String sqlString = "SELECT * FROM Products WHERE productId = '"+productStr+"' ";
            rs = conn.createStatement().executeQuery(sqlString);
        }
        catch (Exception e)
        {

        }

        return rs;
    }
}
