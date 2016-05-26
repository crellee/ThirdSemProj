package Database;

import java.sql.Connection;
import java.sql.Statement;

/**
 * Created by kristinOlof on 09-05-2016.
 */
public class DummyInfo
{
    private static DummyInfo singleton = new DummyInfo( );

    public DummyInfo()
    {
    }

    public static DummyInfo getInstance( ) {
        return singleton;
    }

    public void createDummyInfo()
    {
        String sqlString, sqlString1, sqlString2, sqlString3;
        Statement stmt, stmt1, stmt2, stmt3;

        try {
            Connection conn = DBConnection.getConnection();
            stmt = conn.createStatement();

            sqlString ="INSERT INTO customer (customerFirstName, customerLastName, email, zipCode)" +
                    "VALUES('Hanne','Frank','hanne@live.dk', 2500 )," +
                    "('Bo', 'Gremling', 'bobo@gmail.dk', 2200 )," +
                    "('Jarla', 'Nilsen', 'jn@mail.dk', 3500 )," +
                    "('Bob', 'Larsen', 'bob@mail.dk', 2000 )," +
                    "('Asger', 'Clausen', 'abc@mail.dk', 3500 )," +
                    "('Arne', 'Kildentoft', 'ak@mail.dk', 2200 )," +
                    "('Roi', 'Joinsson', 'rje@mail.dk', 2300 )," +
                    "('Christian', 'Hasselstrøm', 'crellee@mail.dk', 2200 )," +
                    "('Kristin', 'Helgadóttir', 'kh@mail.dk', 3520 )," +
                    "('Nathalie', 'Larsen', 'nl@mail.dk', 3390 )";
            stmt.executeUpdate(sqlString);

            stmt1 = conn.createStatement();
            sqlString1 ="INSERT INTO employee (employeeId, employeeName)" +
                    "VALUES(1,'Josefine'),(2,'Andreas'),(3,'Freja'), (4,'Tim'), (5,'Kim');";

            stmt1.executeUpdate(sqlString1);

            stmt2 = conn.createStatement();
            sqlString2 = "INSERT INTO imercocard(imercoCardId, customerId, point)"+
                    "VALUES(1, 1, 12), (2, 2, 225), (3, 3, 55), (4, 4, 30), (5, 5, 4), " +
                    "(6, 6, 10), (7, 7, 100), (8, 8, 34), (9, 9, 90), (10, 10, 210);";

            stmt2.executeUpdate(sqlString2);

            stmt3 = conn.createStatement();
            sqlString3 = "INSERT INTO imerco_project.products(productId, productName, productDescription, price, discount)"+
                    "VALUES(15, 'Vase', 'Vase med guldflager', 399, NULL), " +
                    "(1545, 'Tæppe', 'Cotton fluffy', 299, NULL)," +
                    "(4578, 'Beslag', 'Messingbeslag rustfrit', 159, NULL), " +
                    "(12, 'Gryde', 'Kvalitets gryde', 399, NULL), " +
                    "(13, 'Kasserolle', 'Cook & Baker Kasserolle', 199, NULL), " +
                    "(20, 'Grydesæt', 'Jamie Oliver Grydesæt', 1199, NULL), " +
                    "(30, 'Ovnfast fad', 'Casa Ovnfast fad 20 cm', 99, NULL), " +
                    "(31, 'Ovnfast skål', 'Kähler Ovnfast skål', 249, NULL), " +
                    "(70, 'Grillhandske', 'Cook & Baker Grillhandske', 99, NULL), " +
                    "(100, 'Kokkekniv', 'Forskærerkniv 21 cm Stål', 399, NULL), " +
                    "(101, 'Brødkniv', 'Cook & Baker Brødkniv', 249, NULL), " +
                    "(300, 'Ølglas', 'Rosendahl Ølglas', 249, NULL), " +
                    "(301, 'Whiskyglas', 'Luigi Bormioli Whiskyglas', 99, NULL), " +
                    "(302, 'Vinglas', 'Eva Solo Rødvinsglas', 189, NULL), " +
                    "(400, 'Kaffekværn', 'Bodum Bistro', 299, NULL), " +
                    "(500, 'Blender', 'Braun Blender Sort', 799, NULL);";

            stmt3.executeUpdate(sqlString3);
        }
        catch (Exception e)
        {

        }
    }
}
