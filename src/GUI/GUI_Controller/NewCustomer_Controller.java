package GUI.GUI_Controller;

import Database.CreateCustomer;
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

    @FXML
    Button continueBtn;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {

    }

    public void saveCustToDatabase()
    {
        if(CreateCustomer.createCustomer(firstNameField, lastNameField, emailField, zipField))
        {
            newCustomerClose();
            openImercoNumWindow();
        }
    }

    public void openImercoNumWindow()
    {
        Stage imercoNuwStage = new Stage();
        Parent root = null;
        try
        {
            root = FXMLLoader.load(getClass().getResource("/GUI/FXML_EnterImercoNumWindow.fxml"));
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        Scene scene = new Scene(root);
        imercoNuwStage.setScene(scene);
        imercoNuwStage.show();
    }


    public void newCustomerClose()
    {
        Stage newCustStage = (Stage) continueBtn.getScene().getWindow();
        newCustStage.close();
    }
}
