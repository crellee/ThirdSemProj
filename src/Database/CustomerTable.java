package Database;

import java.sql.Connection;
import java.sql.Statement;

/**
 * Created by kristinOlof on 03-05-2016.
 */
public class CustomerTable
{
    private static CustomerTable singleton = new CustomerTable( );

    /* A private Constructor prevents any other
     * class from instantiating.
     */
    private CustomerTable(){ }

    /* Static 'instance' method */
    public static CustomerTable getInstance( ) {
        return singleton;
    }

    public void createTable()
    {
        String sqlString;
        Statement stmt;

        try {
            Connection conn = DBConnection.getConnection();
            stmt = conn.createStatement();

            System.out.println("Der");
            sqlString = "CREATE TABLE IF NOT EXISTS Customer " +
                    "(customerId INT(3) NOT NULL, " +
                    "customerFirstName VARCHAR(30) , " +
                    "customerLastName VARCHAR(30) , " +
                    "email VARCHAR(40) NOT NULL, " +
                    "zipCode SMALLINT(4) , " +
                    "PRIMARY KEY (customerId) )";


            stmt.executeUpdate(sqlString);
            System.out.println("og her");
        }
        catch (Exception e)
        {

        }
    }
}
