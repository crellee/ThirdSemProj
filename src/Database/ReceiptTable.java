package Database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by roije on 03/05/2016.
 */
public class ReceiptTable
{
    private static ReceiptTable singleton = new ReceiptTable( );

    /* A private Constructor prevents any other
     * class from instantiating.
     */
    private ReceiptTable(){ }

    /* Static 'instance' method */
    public static ReceiptTable getInstance( ) {
        return singleton;
    }

    String sqlString;
    Statement stmt;

    public void createTable()
    {
        try
        {
            Connection conn = DBConnection.getConnection();
            stmt = conn.createStatement();

            sqlString = "CREATE TABLE IF NOT EXISTS Receipts " +
                    "(receiptId INTEGER(10) NOT NULL, " +
                    "employeeId INTEGER(10) NOT NULL, " +
                    "imercoCardId INTEGER(10) NOT NULL, " +
                    "dateIssued VARCHAR (10), " +
                    "paymentType VARCHAR (20), " +
                    "PRIMARY KEY (productId))";

            stmt.executeUpdate(sqlString);

        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}