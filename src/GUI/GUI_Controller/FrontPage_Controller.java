package GUI.GUI_Controller;

import Database.EmployeeLoginVerifier;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by roije on 09/05/2016.
 */
public class FrontPage_Controller implements Initializable
{

    @FXML
    private Button loginBtn;

    @FXML
    private Label errorLabel;

    @FXML
    private TextField empNumField;

    @FXML
    private Button submitBtn;


    @Override
    public void initialize(URL location, ResourceBundle resources)
    {

    }

    @FXML
    public void openLoginWindow() throws IOException
    {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/FXML_LoginWindow.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void resetLabel()
    {
        errorLabel.setVisible(false);
    }

    private void changeToHomePage()
    {
        Main_Controller main_controller = Main_Controller.getInstance();
        Parent root = null;
        try
        {

            root = FXMLLoader.load(getClass().getResource("/GUI/FXML_HomePage.fxml"));
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        Stage homeScreenStage = main_controller.getStage();
        Scene scene = new Scene(root);
        homeScreenStage.setScene(scene);
        main_controller.showStage();
    }

    @FXML
    public void checkLogin()
    {
        EmployeeLoginVerifier verifier = new EmployeeLoginVerifier();

        if (verifier.verifyUser(empNumField))
        {
            Stage loginStage = (Stage) submitBtn.getScene().getWindow();
            loginStage.close();
            changeToHomePage();

        }
        else
        {
            errorLabel.setText("Invalid employee number");
            errorLabel.setVisible(true);
        }
    }

    public void shutDownProgram()
    {
        System.exit(0);
    }
}


