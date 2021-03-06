package Database;

import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by christianhasselstrom on 23/05/2016.
 * #TheChamp
 */
public class Return
{
    static int receiptIdstat;
    static int imercoCardIdstat;
    static int saleIdstat;
    static double totalDoub;

    public static boolean findReceipt(TextField receiptId, TextField imercoCardId) {
        boolean verified = false;
        int receiptIdInt = Integer.parseInt(receiptId.getText());
        int imercoCardIdInt = Integer.parseInt(imercoCardId.getText());
        receiptIdstat = receiptIdInt;
        imercoCardIdstat = imercoCardIdInt;

        try {
            Connection conn = DBConnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs;

            if (receiptId != null) {
                String sqlString = "SELECT * FROM Receipts WHERE receiptId = '" + receiptIdInt + "' " +
                        "and imercoCardId = '"+imercoCardIdInt+"' ";
                rs = stmt.executeQuery(sqlString);

                if (rs.next())
                {
                    verified = true;
                }
            }

        } catch (SQLException e) {

        }
        return verified;
    }

    public static ResultSet toFillTable()
    {
        ResultSet rs = null;
        try
        {
            Connection conn = DBConnection.getConnection();
            Statement stmt = conn.createStatement();

            String sqlString = "select * from Imerco_Project.Products as p1 " +
                    "inner join (select * from Imerco_Project.Sales) as s1 " +
                    "inner join Imerco_Project.Receipts as r1 " +
                    "where r1.receiptId = '"+receiptIdstat+"' " +
                    "and r1.saleId = s1.saleId " +
                    "and s1.productId = p1.productId ";
            rs = stmt.executeQuery(sqlString);
        }
        catch (SQLException e)
        {

        }
        return rs;
    }
    /*
    select * from Imerco_Project.Products as p1
inner join (select * from Imerco_Project.Sales) as s1
inner join Imerco_Project.Receipts as r1
where r1.receiptId = 6
and r1.saleId = s1.saleId
and s1.productId = p1.productId

*/
    public static void updateSalesTable(int saleId, int amount, int productId) throws SQLException
    {
        totalDoub = 0;
        String sqlString = "";
        int amountInTable = totalAmounts(productId, saleId);
        int num = amountInTable - amount;
        Connection conn = DBConnection.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = null;

        sqlString = "UPDATE Sales SET ammountOfProducts = '"+num+"' where saleId = '"+saleId+"' " +
                "and productId = '"+productId+"' ";
        stmt.executeUpdate(sqlString);

        String sqlString2 = "select * from Products where productId = '"+productId+"' ";
        rs = stmt.executeQuery(sqlString2);

        while(rs.next())
        {
            totalDoub = totalDoub + rs.getDouble("price");
        }
    }

    public static int totalAmounts(int productId, int saleId) throws SQLException
    {
        int i = -1;
        ResultSet rs = null;
        try
        {
            Connection conn = DBConnection.getConnection();
            Statement stmt = conn.createStatement();

            String sqlString = "SELECT ammountOfProducts from Sales where productId = '"+productId+"' and saleId = '"+saleId+"' ";
            rs = stmt.executeQuery(sqlString);
        } catch (SQLException e)
        {

        }
        while (rs.next())
        {
            i = rs.getInt("ammountOfProducts");
        }
        return i;
    }

    public static double getTotalDoub()
    {
        return totalDoub;
    }

    public static void newMethod(int productId) throws SQLException
    {
        String sqlString = "";
        double tmp = 0;
        ResultSet rs = null;


        Connection conn = DBConnection.getConnection();
        Statement stmt = conn.createStatement();

        String sqlString2 = "select * from Products where productId = '"+productId+"' ";
        rs = stmt.executeQuery(sqlString2);

        while(rs.next())
        {
            tmp = rs.getDouble("price");
            totalDoub = totalDoub + tmp;
        }
    }
    public static int getImercoCardIdstat() {
        return imercoCardIdstat;
    }

    public static void updateImercoPoints(int newPoint) throws SQLException
    {
        Connection conn = DBConnection.getConnection();
        Statement stmt = conn.createStatement();

        String sqlString = "update ImercoCard set point = point - '"+newPoint+"' " +
                "where imercoCardId = '"+imercoCardIdstat+"' ";
        stmt.executeUpdate(sqlString);
    }

    public static void resetStatics()
    {
        receiptIdstat = 0;
        imercoCardIdstat = 0;
        saleIdstat = 0;
        totalDoub = 0;
    }
}
