package Database;

import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

/**
 * Created by christianhasselstrom on 13/05/2016.
 */
public class EndSale
{
    static Random ran = new Random();
    static int recieptIdInt = ran.nextInt(100000);
    static int saltIdInt = ran.nextInt(10000);
    static int imercoCardId;

    public static void createReciept(TextField imercoCardID, String paymentTypeId)
    {


        //sets i dags dato
        Calendar c = new GregorianCalendar();
        c.set(Calendar.HOUR_OF_DAY, 0); //anything 0 - 23
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        Date d1 = c.getTime();

        String employeeStr = EmployeeLoginVerifier.getEmail().toString();
        int imercoIdInt = Integer.parseInt(imercoCardID.toString());

        String paymentTypeStr = paymentTypeId;
        String dateStr = d1.toString();


        try
        {
            Connection conn = DBConnection.getConnection();
            Statement stmt = conn.createStatement();

            String sqlString = ("INSERT INTO Reciepts (receiptId, employeeId, imercoCardId, dateIssued, paymentType) " +
                    "VALUES ('"+recieptIdInt+"' , '"+employeeStr+"' , '"+imercoIdInt+"' , '"+dateStr+"' , '"+paymentTypeStr+"' ) ");
            stmt.executeUpdate(sqlString);
        }
        catch (Exception e)
        {

        }
    }

    public void createSales(int productId, int amountOfProd)
    {
        try
        {
            Connection conn = DBConnection.getConnection();
            Statement stmt = conn.createStatement();

            String sqlString = ("INSERT INTO Sales (saleId, productId, ammountOfProducts) " +
                    "VALUES ('"+saltIdInt+"' , '"+productId+"' , '"+recieptIdInt+"' , '"+amountOfProd+"' ) ");
            stmt.executeUpdate(sqlString);
        }
        catch (Exception e)
        {

        }
    }

    public static boolean verifyImercoCard(TextField textField)
    {

        boolean verified = false;
        imercoCardId = Integer.parseInt(textField.getText());

        try {
            Connection conn = DBConnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs;

            if (textField != null)
            {
                String sqlString = "SELECT * FROM ImercoCard WHERE imercoCardId = '" + imercoCardId + "'";
                rs = stmt.executeQuery(sqlString);

                if (rs.next())
                {
                    verified = true;
                    setImercoCard(textField);
                }
            }

        } catch (SQLException e) {

        }
        return verified;

    }

    public static void setImercoCard(TextField textField)
    {
        int imercoInt = Integer.parseInt(textField.getText());
        imercoCardId = imercoInt;
    }

    public static Integer getImercoCard()
    {
        return imercoCardId;
    }



        public static ResultSet getImercoPoints()
        {

            ResultSet rs = null;
            try
            {
                Connection conn = DBConnection.getConnection();
                String sqlString = "SELECT * " +
                        "FROM ImercoCard WHERE imercoCardId = '"+imercoCardId+"' ";
                rs = conn.createStatement().executeQuery(sqlString);
            }
            catch (Exception e)
            {

            }

            return rs;
        }


}
