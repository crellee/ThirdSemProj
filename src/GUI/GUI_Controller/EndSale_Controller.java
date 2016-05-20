package GUI.GUI_Controller;

import Model.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
 * Created by kristinOlof on 19-05-2016.
 */
public class EndSale_Controller implements Initializable
{
    Stage endSaleStage = new Stage();

    @FXML
    private Button cashBtn;

    @FXML
    private Button cardBtn;

    @FXML
    private Button fFCardBtn;


    ObservableList<Product> allProducts = FXCollections.observableArrayList();

    ProductGUI_Intermediary productGUIIntermediary = ProductGUI_Intermediary.getInstance();


    @Override
    public void initialize(URL location, ResourceBundle resources)
    {

    }

    public void showEndSale() throws IOException
    {
        Stage endSale = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/FXML_EndSale.fxml"));
        Scene scene = new Scene(root);
        endSale.setScene(scene);
        endSale.show();
    }
}
