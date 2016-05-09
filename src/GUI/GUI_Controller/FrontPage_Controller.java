package GUI.GUI_Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by roije on 09/05/2016.
 */
public class FrontPage_Controller implements Initializable
{


    @FXML
    private Button loginBtn;


    @Override
    public void initialize(URL location, ResourceBundle resources)
    {

    }

    public Button getLoginBtn()
    {
        return loginBtn;
    }


    public void openLoginWindow() throws IOException
    {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/FXML_LoginWindow.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void shutDownProgram()
    {
        System.exit(0);
    }
}
