package Database;

import javafx.scene.control.TextField;

import java.sql.Connection;
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
    public static void createReciept(TextField imercoCardID, String paymentTypeId)
    {
        //sets todays date
        Calendar c = new GregorianCalendar();
        c.set(Calendar.HOUR_OF_DAY, 0); //anything 0 - 23
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        Date d1 = c.getTime();

        String employeeStr = EmployeeLoginVerifier.getEmail().toString();
        int imercoIdInt = Integer.parseInt(imercoCardID.toString());
        Random ran = new Random();
        int recieptIdInt = ran.nextInt(100000);
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
}
