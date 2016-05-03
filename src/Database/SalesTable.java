package Database;

import java.sql.Connection;
import java.sql.Statement;

/**
 * Created by christianhasselstrom on 03/05/2016.
 */
public class SalesTable
{
    private static SalesTable singleton = new SalesTable();

    private SalesTable()
    {
    }

    public static SalesTable getInstance()
    {
        return singleton;
    }

    public void createTable()
    {
        String sqlString;
        Statement stmt;

        try
        {
            Connection conn = DBConnection.getConnection();
            stmt = conn.createStatement();

            System.out.println("Her virker det arh hvad");
            sqlString = "CREATE TABLE IF NOT EXISTS Sales " +
                    "(saleId INT(10) NOT NULL, " +
                    "productId INT(10) NOT NULL, " +
                    "receiptId INT(10) NOT NULL, " +
                    "ammountOfProducts INT(4) NOT NULL, " +
                    "FOREIGN KEY (productId) REFERENCES Products(productId), " +
                    "FOREIGN KEY (receiptId) REFERENCES Receipts(receiptId), " +
                    "PRIMARY KEY (saleId, productId, receiptId))";

            stmt.executeUpdate(sqlString);
            System.out.println("arh hvad Der virker det også?");
        }
        catch (Exception e)
        {

        }
    }
}
