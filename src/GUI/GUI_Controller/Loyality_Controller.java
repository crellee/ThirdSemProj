package GUI.GUI_Controller;

import Database.EndSale;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
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
            SalePage_Controller salePage_controller = new SalePage_Controller();
            salePage_controller.setLoyaltyPoints();
        }
    }
    public void loyalityClose()
    {
        Stage loyalityStage = (Stage) cancelButton.getScene().getWindow();
        loyalityStage.close();
    }
}
