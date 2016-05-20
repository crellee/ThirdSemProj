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

            sqlString = "CREATE TABLE IF NOT EXISTS Sales " +
                    "(saleId INTEGER(10) NOT NULL, " +
                    "productId INT(10) NOT NULL, " +
                    "ammountOfProducts INT(4) NOT NULL, " +
                    "FOREIGN KEY (productId) REFERENCES Products(productId), " +
                    "PRIMARY KEY (saleId, productId))";

            stmt.executeUpdate(sqlString);
        }
        catch (Exception e)
        {

        }
    }
}
