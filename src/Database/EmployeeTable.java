package Database;

import java.sql.Connection;
import java.sql.Statement;

/**
 * Created by christianhasselstrom on 03/05/2016.
 */
public class EmployeeTable
{
    public void createTable()
    {
        String sqlString;
        Statement stmt;

        try
        {
            Connection conn = DBConnection.getConnection();
            stmt = conn.createStatement();

            System.out.println("Her");
            sqlString = "CREATE TABLE IF NOT EXISTS Employee " +
                    "(employeeId INT(3) NOT NULL, " +
                    "employeeName VARCHAR(20) NOT NULL, " +
                    "PRIMARY KEY (employeeId) )";



            stmt.executeUpdate(sqlString);
            System.out.println("Der");
        }
        catch (Exception e)
        {

        }
    }
}
