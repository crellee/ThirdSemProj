package GUI.GUI_Controller;

import Database.CreateCustomer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by roije on 19/05/2016.
 */
public class EnterImercoNum_Controller implements Initializable
{
    @FXML
    TextField imercoCardField;

    @FXML
    Label validLbl;

    @FXML
    Button okButton;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {

    }

    public void createImercoCard()
    {

        if(!CreateCustomer.createImercoCard(imercoCardField))
        {
            validLbl.setText("Imerco Card is all ready in use");
        }
        else
        {
            Stage actualStage = (Stage) okButton.getScene().getWindow();
            actualStage.close();
        }

    }
}
