package GUI.GUI_Controller;

import Database.EndSale;
import Model.ImercoCard;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Created by christianhasselstrom on 17/05/2016.
 */
public class Loyality_Controller implements Initializable
{
    @FXML
    private Button cancelButton;

    @FXML
    private Button okButton;

    @FXML
    private TextField textField;

    @FXML
    private Label pointsLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {

    }


    public void showLoyalityWindow() throws IOException
    {
        Stage loyalityStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/FXML_LoyalityWindow.fxml"));
        Scene scene = new Scene(root);
        loyalityStage.setScene(scene);
        loyalityStage.show();
    }

    public void loyalityHandler()
    {

        if(EndSale.verifyImercoCard(textField) == true)
        {
            EndSale.setImercoCard(textField);
            System.out.println(EndSale.getImercoCard());
            Stage loyalityStage = (Stage) okButton.getScene().getWindow();
            loyalityStage.close();
        }
    }

    public void setLoyaltyPoints()
    {
        //pointLabel.setText(" " + EndSale.getImercoCard());

        if(EndSale.verifyImercoCard(textField) == true)
        {
            EndSale.setImercoCard(textField);


            try {
                ResultSet rs = EndSale.getImercoPoints();
                while (rs.next()) {
                    ImercoCard imercoCard = new ImercoCard();
                    int points = imercoCard.setActivePoints(rs.getInt("point"));
                    pointsLabel.setText("Points: " + points);


                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else
        {
            pointsLabel.setText("Invalid card number");
        }
    }

    public void loyalityClose()
    {
        Stage loyalityStage = (Stage) cancelButton.getScene().getWindow();
        loyalityStage.close();
    }
}
