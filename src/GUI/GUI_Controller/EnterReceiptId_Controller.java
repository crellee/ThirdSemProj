package GUI.GUI_Controller;

import Database.CreateCustomer;
import Database.Return;
import Model.Receipt;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by christianhasselstrom on 23/05/2016.
 */
public class EnterReceiptId_Controller implements Initializable
{
    @FXML
    TextField receiptIdField;

    @FXML
    Label validLbl;

    @FXML
    Button okButton;

    @FXML
    TextField imercoCardField;


    @Override
    public void initialize(URL location, ResourceBundle resources)
    {

    }

    public void getReceiptContent() throws IOException
    {
        if(receiptIdField.getText().isEmpty())
        {
            validLbl.setText("Please insert a receipt");
        }

        if(!Return.findReceipt(receiptIdField, imercoCardField))
        {
            validLbl.setText("Receipt doesn't exist");
        }
        //else if(!Return.findReceipt(receiptIdField) )
        else
        {
            Stage actualStage = (Stage) okButton.getScene().getWindow();
            actualStage.close();

            Stage stage2 = new Stage();
            stage2.initStyle(StageStyle.UNDECORATED);
            Parent root = FXMLLoader.load(getClass().getResource("/GUI/FXML_ReturVare.fxml"));
            Scene scene = new Scene(root);
            stage2.setScene(scene);
            stage2.show();
        }
    }


}
