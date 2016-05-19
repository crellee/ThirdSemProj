package Database;

import java.sql.Connection;
import java.sql.Statement;

/**
 * Created by kristinOlof on 09-05-2016.
 */
public class DummieInfo
{
    private static DummieInfo singleton = new DummieInfo( );

    public DummieInfo()
    {
    }

    public static DummieInfo getInstance( ) {
        return singleton;
    }

    public void customerInfo()
    {
        String sqlString, sqlString1, sqlString2, sqlString3;
        Statement stmt, stmt1, stmt2, stmt3;

        try {
            Connection conn = DBConnection.getConnection();
            stmt = conn.createStatement();

            sqlString ="INSERT INTO customer (customerFirstName, customerLastName, email, zipCode)" +
                    "VALUES('Hanne','Frank','hanne@live.dk', 2500 )," +
                    "('Bo', 'Gremling', 'bobo@gmail.dk', 2200)," +
                    "('Jarla', 'Nilsen', 'jn@mail.dk', 3500)";


            stmt.executeUpdate(sqlString);

            stmt1 = conn.createStatement();
            sqlString1 ="INSERT INTO employee (employeeId, employeeName)" +
                    "VALUES(25,'Josefine'),(36,'Andreas'),(14,'Freja');";

            stmt1.executeUpdate(sqlString1);

            stmt2 = conn.createStatement();
            sqlString2 = "INSERT INTO imercocard(imercoCardId, customerId, point)"+
                    "VALUES(5, 15, 12),(8, 11, 225),(6, 5, 55);";

            stmt2.executeUpdate(sqlString2);

            stmt3 = conn.createStatement();
            sqlString3 = "INSERT INTO imerco_project.products(productId, productName, productDescription, price, discount)"+
                    "VALUES(15, 'Vase', 'Vase med guldflager', 3999, NULL), " +
                    "(1545, 'Teppe', 'Cotton fluffy', 299, NULL)," +
                    "(4578, 'Beslag', 'Messingbeslag rustfrit', 159, NULL);";

            stmt3.executeUpdate(sqlString3);
        }
        catch (Exception e)
        {

        }
    }
}
