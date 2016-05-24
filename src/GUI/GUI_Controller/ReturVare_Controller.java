package GUI.GUI_Controller;

import Database.ProductVerifier;
import Database.Return;
import Model.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Created by christianhasselstrom on 23/05/2016.
 */
public class ReturVare_Controller implements Initializable
{

    ProductGUI_Intermediary productGUI_intermediary = ProductGUI_Intermediary.getInstance();

    ObservableList<Product> allProducts = FXCollections.observableArrayList();

    @FXML
    TableColumn productIdCol;

    @FXML
    TableColumn productNameCol;

    @FXML
    TableColumn priceCol;

    @FXML
    TableView<Product> mainTable;



    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        FromDBtoTable();
    }

    public void FromDBtoTable()
    {
        productIdCol.setCellValueFactory(new PropertyValueFactory<Product, Integer>("productId"));
        productNameCol.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));
        priceCol.setCellValueFactory(new PropertyValueFactory<Model.Product, Double>("price"));


        try
        {
            ResultSet rs = Return.toFillTable();
            while (rs.next())
            {

                Model.Product product = new Model.Product();

                int h = rs.getInt("ammountOfProducts");

                product.setProductId(rs.getInt("productId"));
                product.setName(rs.getString("productName"));
                product.setPrice(rs.getInt("price"));

                for(int i = 0; i < h; i++)
                {
                    allProducts.addAll(product);
                    mainTable.setItems(allProducts);
                }
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void productToReturn()
    {
        Product product = mainTable.getSelectionModel().getSelectedItem();
        product.setAmount(1);
        allProducts.remove(product);
        mainTable.setItems(allProducts);
        productGUI_intermediary.addOneProduct(product);
    }

    public void registerProduct() throws IOException {

        Stage stage2 = (Stage) mainTable.getScene().getWindow();
        stage2.close();

        Stage stage1 = new Stage();
        Parent root1 = FXMLLoader.load(getClass().getResource("/GUI/FXML_SalePageReturn.fxml"));
        Scene scene1 = new Scene(root1);
        stage1.setScene(scene1);
        stage1.show();

    }


}
