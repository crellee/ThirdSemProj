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
public class NewCustomer_Controller implements Initializable
{
    @FXML
    TextField firstNameField;

    @FXML
    TextField lastNameField;

    @FXML
    TextField emailField;

    @FXML
    TextField zipField;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {

    }

    public void saveCustToDatabase()
    {
        CreateCustomer.createCustomer(firstNameField, lastNameField, emailField, zipField);
    }
}
