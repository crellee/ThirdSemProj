package GUI.GUI_Controller;

import Database.EndSale;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by christianhasselstrom on 17/05/2016.
 */
public class Loyality_Controller implements Initializable
{
    @FXML
    private Button okButton;

    @FXML
    private TextField textField;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {

    }
    public void loyalityHandler()
    {

        if(EndSale.verifyImercoCard(textField) == true)
        {
            EndSale.setImercoCard(textField);
            System.out.println(EndSale.getImercoCard());
        }

    }
}
