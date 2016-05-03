package Database;

import java.sql.Connection;
import java.sql.Statement;

/**
 * Created by christianhasselstrom on 03/05/2016.
 */
public class ImercoCardTable
{
    private static ImercoCardTable singleton = new ImercoCardTable();

    private ImercoCardTable()
    {
    }
    public static ImercoCardTable getInstance()
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

            sqlString = "CREATE TABLE IF NOT EXISTS ImercoCard " +
                    "(imercoCardId INT(10) NOT NULL, " +
                    "customerId INT(7), " +
                    "point INT(10), " +
                    "FOREIGN KEY (customerId) REFERENCES Customer(customerId), " +
                    "PRIMARY KEY (imercoCardId))";

            stmt.executeUpdate(sqlString);
        }
        catch (Exception e)
        {

        }
    }
}
