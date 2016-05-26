package Database;

import Model.ImercoCard;
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

    static int imercoCardId;


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


    public static void updateImercoPoints(int newPoints)
    {

        int points = 0;
        try
        {
            ResultSet rs = EndSale.getImercoPoints();
            while (rs.next())
            {
                ImercoCard imercoCard = new ImercoCard();
                points = imercoCard.setActivePoints(rs.getInt("point"));
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        points = points + newPoints;

        try
        {
            Connection conn = DBConnection.getConnection();
            Statement stmt = conn.createStatement();

            String sqlString = "UPDATE Imerco_Project.ImercoCard " +
                    "SET point = '"+points+"' where imercoCardId = '"+imercoCardId+"' ";
            stmt.execute(sqlString);
        }
        catch (Exception e)
        {

        }

    }

    public static void resetStatics()
    {
        imercoCardId = 0;
    }
}

