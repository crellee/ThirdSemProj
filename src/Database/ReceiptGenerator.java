package Database;

import Model.Employee;
import Model.ImercoCard;
import Model.Product;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by roije on 20/05/2016.
 */
public class ReceiptGenerator
{
    private int saledId;

    public void generateSale(ObservableList<Product> allProducts)
    {
        int saleId = createUniqueSaleId();
        this.saledId = saleId;
        for (Product product : allProducts)
        {
            try
            {
                Connection conn = DBConnection.getConnection();
                Statement stmt = conn.createStatement();

                System.out.println("Her");
                String sqlString = ("INSERT INTO Sales (saleId, productId, ammountOfProducts) " +
                        "VALUES ('" + saleId + "' , '" + product.getProductId() + "' , '" + product.getAmount() +"')");
                stmt.executeUpdate(sqlString);
                System.out.println("Der");

            } catch (Exception e) {

            }
        }
        System.out.println(saleId);

    }

    public int createUniqueSaleId()
    {
        int lastItemId = 0;
        try
        {
            Connection conn = DBConnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs;

            String sqlString = ("SELECT * FROM Sales ORDER BY saleId DESC LIMIT 1");
            rs = stmt.executeQuery(sqlString);

            if(rs.next())
            {
                lastItemId = rs.getInt("saleId");
            }
            else
            {
                return lastItemId;
            }

        } catch (Exception e) {

        }
        return lastItemId + 1;
    }


    public void generateReceipt(Button buttonSrc, int employeeId, int imercoCardNum)
    {
        //sets i dags dato
        Calendar c = new GregorianCalendar();
        c.set(Calendar.HOUR_OF_DAY, 0); //anything 0 - 23
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        Date d1 = c.getTime();
        String dateStr = d1.toString();
        String test = "test";

        String paymentType = buttonSrc.getText();



        try
        {
            Connection conn = DBConnection.getConnection();
            Statement stmt = conn.createStatement();

            String sqlString;

            if(imercoCardNum == 0)
            {
                sqlString = ("INSERT INTO Receipts (saleId, employeeId, dateIssued, paymentType) " +
                        "VALUES ('" + this.saledId + "' , '" + employeeId + "' , '"+test+"', '"+paymentType+"')");
            }
            else
            {
                sqlString = ("INSERT INTO Receipts (saleId, employeeId, imercoCardId, dateIssued, paymentType) " +
                        "VALUES ('" + this.saledId + "' , '" + employeeId + "' , '" + imercoCardNum + "', '" + test + "', '" + paymentType + "')");
            }
            stmt.executeUpdate(sqlString);

        } catch (Exception e) {

        }
    }
}
