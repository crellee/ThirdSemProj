package Database;

import java.sql.Connection;
import java.sql.Statement;

/**
 * Created by kristinOlof on 09-05-2016.
 */
public class DummieInfo
{
    public void customerInfo()
    {
        String sqlString, sqlString1, sqlString2;
        Statement stmt, stmt1, stmt2;

        try {
            Connection conn = DBConnection.getConnection();
            stmt = conn.createStatement();

            sqlString ="INSERT INTO customer (customerId, customerFirstName, customerLastName, email, zipCode)" +
                    "VALUES( 15 ,'  Hanne ',' Frank ',' hanne@live.dk ', 2500 );" +
                    "INSERT INTO imerco_project.customer(customerId, customerFirstName, customerLastName, email, zipCode)\n" +
                    "VALUES(11, 'Bo', 'Gremling', 'bobo@gmail.dk', 2200);" +
                    "INSERT INTO imerco_project.customer(customerId, customerFirstName, customerLastName, email, zipCode)\n" +
                    "VALUES(5, 'Jarla', 'Nilsen', 'jn@mail.dk', 3500);";


            stmt.executeUpdate(sqlString);

            stmt1 = conn.createStatement();
            sqlString1 ="INSERT INTO employee (employeeId, employeeName)" +
                    "VALUES(25,'Josefine');" +
                    "INSERT INTO imerco_project.employee(employeeId, employeeName)" +
                    "VALUES(36,'Andreas');" +
                    "INSERT INTO imerco_project.employee(employeeId, employeeName)" +
                    "VALUES(14,'Freja');";

            stmt1.executeUpdate(sqlString1);

            stmt2 = conn.createStatement();
            sqlString2 = "INSERT INTO imercocard(imercoCardId, customerId, point)"+
                    "VALUES(5, 15, 12);"+
                    "INSERT INTO imerco_project.imercocard(imercoCardId, customerId, point)"+
                    "VALUES(8, 11, 225);"+
                    "INSERT INTO imerco_project.imercocard(imercoCardId, customerId, point)"+
                    "VALUES(6, 5, 55);";

            stmt2.executeUpdate(sqlString2);

        }
        catch (Exception e)
        {

        }
    }
}
