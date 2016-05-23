package Database;

import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by christianhasselstrom on 23/05/2016.
 */
public class Return
{
    public static boolean findReceipt(TextField receiptId)
    {
        boolean verified = false;
        int receiptIdInt = Integer.parseInt(receiptId.getText());

        try {
            Connection conn = DBConnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs;

            if (receiptId != null)
            {
                String sqlString = "SELECT * FROM Receipts WHERE receiptId = '" + receiptIdInt + "'";
                rs = stmt.executeQuery(sqlString);

                if (rs.next())
                {
                    verified = true;
                }
            }

        } catch (SQLException e)
        {

        }
        return verified;
    }
}
