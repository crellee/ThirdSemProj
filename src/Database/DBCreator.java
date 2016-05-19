package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * Created by christianhasselstrom on 03/05/2016.
 */
public class DBCreator
{
    //DatabaseController URL
    final static String DB_URL = "jdbc:mysql://localhost/";

    //  DatabaseController credentials
    final static String USER = "root";
    final static String PASS = "blaBla";

    public static void create()
    {
        Connection conn;
        Statement stmt;
        try
        {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query
            stmt =  conn.createStatement();

            String sql = "CREATE DATABASE IF NOT EXISTS Imerco_Project";
            stmt.executeUpdate(sql);

        }
        catch (Exception se)
        {

        }
    }
}
