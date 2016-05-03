package Database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by roije on 03/05/2016.
 */
public class ProductsTable
{
    String sqlString;
    Statement stmt;

    public void createTable()
    {
        try
        {
            Connection conn = DBConnection.getConnection();
            stmt = conn.createStatement();

            sqlString = "CREATE TABLE IF NOT EXISTS Products " +
                    "(productId INTEGER(10) NOT NULL, " +
                    "productName VARCHAR(25), " +
                    "productDescription VARCHAR(50), " +
                    "price DOUBLE(10, 2), " +
                    "discount TINYINT(10), " +
                    "PRIMARY KEY (productId))";

            stmt.executeUpdate(sqlString);

        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
