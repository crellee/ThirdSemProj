package Database;

import java.sql.Connection;
import java.sql.Statement;

/**
 * Created by christianhasselstrom on 03/05/2016.
 */
public class EmployeeTable
{
    private static EmployeeTable singleton = new EmployeeTable( );

    /* A private Constructor prevents any other
     * class from instantiating.
     */
    private EmployeeTable()
    {

    }

    /* Static 'instance' method */
    public static EmployeeTable getInstance( ) {
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

            sqlString = "CREATE TABLE IF NOT EXISTS Employee " +
                    "(employeeId INT(3) NOT NULL, " +
                    "employeeName VARCHAR(20) NOT NULL, " +
                    "PRIMARY KEY (employeeId) )";

            stmt.executeUpdate(sqlString);
        }
        catch (Exception e)
        {

        }
    }
}
