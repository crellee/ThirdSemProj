package GUI.GUI_Controller;

import Database.CreateCustomer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by roije on 19/05/2016.
 */
public class EnterImercoNum_Controller implements Initializable
{
    @FXML
    TextField imercoCardField;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {

    }

    public void createImercoCard()
    {
        CreateCustomer.createImercoCard(imercoCardField);
    }
}
