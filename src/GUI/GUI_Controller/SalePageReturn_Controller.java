package GUI.GUI_Controller;

import Algorithm.Calculator;
import Database.Return;
import Model.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * Created by roije on 23/05/2016.
 */
public class SalePageReturn_Controller implements Initializable
{

    @FXML
    TableColumn prodId;
    @FXML
    TableColumn productName;
    @FXML
    TableColumn receiptId;
    @FXML
    TableColumn price;
    @FXML
    TableColumn disc;
    @FXML
    TableColumn amount;
    @FXML
    TableView<Product> mainTable;

    @FXML
    Label totalAmountLbl;

    @FXML
    Label discountLbl;

    @FXML
    Label toOweLbl;

    @FXML
    Label paidAmountLbl;

    ObservableList<Product> allProducts = FXCollections.observableArrayList();



    ProductGUI_Intermediary productGUI_intermediary = ProductGUI_Intermediary.getInstance();

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        prodId.setCellValueFactory(new PropertyValueFactory<Product, Integer>("productId"));
        productName.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));
        receiptId.setCellValueFactory(new PropertyValueFactory<Model.Product, String>("receiptId"));
        price.setCellValueFactory(new PropertyValueFactory<Model.Product, Double>("price"));
        disc.setCellValueFactory(new PropertyValueFactory<Model.Product, Integer>("discount"));
        amount.setCellValueFactory(new PropertyValueFactory<Model.Product, Integer>("amount"));



        mainTable.setItems(productGUI_intermediary.getAllProductsToReturn());

        Calculator calculator = new Calculator();


        double totalAmount = calculator.updateTotalAmount(productGUI_intermediary.getAllProductsToReturn());
       totalAmountLbl.setText("-" + Double.toString(totalAmount));

        int discountAmount = calculator.updateDiscount(productGUI_intermediary.getAllProductsToReturn());
        discountLbl.setText(Integer.toString(discountAmount));

        double toOweAmount = calculator.updateToOwe(productGUI_intermediary.getAllProductsToReturn());
        toOweLbl.setText("-" + Double.toString(toOweAmount));

        double paidAmount = calculator.updatePaidAmount();
        paidAmountLbl.setText(Double.toString(paidAmount));

    }

    public void openReturnWindow() throws IOException
    {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/FXML_EnterReceiptId.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void endReturn() throws SQLException
    {
        for (Map.Entry<Integer, ArrayList<Integer>> entry : productGUI_intermediary.getReturnMap().entrySet()) {
            Integer saleIdNum = entry.getKey();
            ArrayList<Integer> numList = entry.getValue();
            for (int productNum : numList)
            {
                Return.updateSalesTable(saleIdNum, 1, productNum);
            }

            //System.out.println(Return.getTotalDoub());

            //totalAmountLbl.setText("" + Return.getTotalDoub());

        }
    }
        /*
        //ArrayList<Integer> testlist = productGUI_intermediary.getReturnMap().get(productGUI_intermediary.getCurrentSaleId());
        Iterator entries = productGUI_intermediary.getReturnMap().entrySet().iterator();
        while (entries.hasNext())
        {
            Integer saleId = (Integer) entries.next();
            try
            {
                Return.updateSalesTable(productGUI_intermediary.getCurrentSaleId(), 1, productId);
            } catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
        */

}

