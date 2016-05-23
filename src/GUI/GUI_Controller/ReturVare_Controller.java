package GUI.GUI_Controller;

import Database.ProductVerifier;
import Database.Return;
import Model.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Created by christianhasselstrom on 23/05/2016.
 */
public class ReturVare_Controller implements Initializable
{

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
                //product.setDescription(rs.getString("productDescription"));
                product.setPrice(rs.getInt("price"));
                //product.setDiscount(rs.getInt("discount"));

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


}
