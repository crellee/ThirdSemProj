package GUI.GUI_Controller;

import Database.ProductVerifier;
import Model.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;

/**
 * Created by christianhasselstrom on 09/05/2016.
 */
public class HomePage_Controller implements Initializable
{



    static int in = 0;
    @FXML
    private TextField textField1;
    @FXML
     TableColumn prodId;
    @FXML
     TableColumn desc;
    @FXML
     TableColumn price;
    @FXML
     TableColumn disc;
    @FXML
     TableColumn amount;
    @FXML
     TableView<Model.Product> mainTable;

    ObservableList<Model.Product> data2 = FXCollections.observableArrayList();



    @Override
    public void initialize(URL location, ResourceBundle resources)
    {

    }

    /*public void addToTable()
    {
        System.out.println(textField1.getText().toString());
        ProductVerifier.verifyProduct(textField1);
    }
    */
    public void addToTable()
    {

        prodId.setCellValueFactory(new PropertyValueFactory<Model.Product, Integer>("productId"));
        desc.setCellValueFactory(new PropertyValueFactory<Model.Product, String>("description"));
        price.setCellValueFactory(new PropertyValueFactory<Model.Product, Double>("price"));
        disc.setCellValueFactory(new PropertyValueFactory<Model.Product, Integer>("discount"));
        //amount.setCellValueFactory(new PropertyValueFactory<Object, Integer>("1"));
        amount.setCellValueFactory(new PropertyValueFactory<Model.Product, Integer>("amount"));


        ObservableList<Model.Product> data = FXCollections.observableArrayList();

        try
        {
            ResultSet rs = ProductVerifier.tableShow(textField1);
            while(rs.next())
            {
                Model.Product product = new Model.Product();

                product.setProductId(rs.getInt("productId"));
                product.setDescription(rs.getString("productDescription"));
                product.setPrice(rs.getInt("price"));
                product.setDiscount(rs.getInt("discount"));
                product.setAmount(1);

                data.add(product);
            }

            data2.addAll(data);
            mainTable.setItems(data2);

        }
        catch(Exception e)
        {

        }
    }
    public void addToTable2()
    {

    }
}
