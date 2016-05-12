package GUI.GUI_Controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by christianhasselstrom on 09/05/2016.
 */
public class HomePage_Controller implements Initializable
{



    @FXML
    private TextField textField1;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {

    }

    public void addToTable()
    {

        System.out.println(textField1.getText().toString());

    }
}
