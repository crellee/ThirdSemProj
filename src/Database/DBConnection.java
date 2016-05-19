package Database;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by christianhasselstrom on 28/04/2016.
 */
public class DBConnection
{
    // Username, password, schema name and path to database
    final static String user = "root";
    final static String pass = "blaBla";
    final static String db = "Imerco_Project";
    final static String url = "jdbc:mysql://localhost/";


    // This method connects to the DatabaseController using the attributes above.
    public static Connection getConnection()
    {
        Connection conn;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url + db, user, pass);
            return conn;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

}
