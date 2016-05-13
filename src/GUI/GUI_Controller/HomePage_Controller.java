package GUI.GUI_Controller;

import Database.ProductVerifier;
import Model.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Created by christianhasselstrom on 09/05/2016.
 */
public class HomePage_Controller implements Initializable
{


    @FXML
    private Label totalAmountLbl;
    private double totalAmountDoub;

    @FXML
    private Label paidAmountLbl;
    private double paidAmountDoub;

    @FXML
    private Label toOweLbl;
    private double toOweDoub;

    @FXML
    private Label discountLbl;
    private int discountInt;

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

    private FirstProductTest firstProductTest = FirstProductTest.getInstance();


    @Override
    public void initialize(URL location, ResourceBundle resources)
    {

    }

    public void toSalePage()
    {
        Product product = getFirstProductFromDB();
        firstProductTest.setFirstProduct(product);

        Main_Controller main_controller = Main_Controller.getInstance();
        Parent root = null;
        try
        {

            root = FXMLLoader.load(getClass().getResource("/GUI/FXML_SalePage.fxml"));
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        Stage homeScreenStage = main_controller.getStage();
        Scene scene = new Scene(root);
        homeScreenStage.setScene(scene);
        main_controller.showStage();

    }

    public Product getFirstProductFromDB()
    {
        try
        {
            ResultSet rs = ProductVerifier.tableShow(textField1);
            while (rs.next())
            {
                Model.Product product = new Model.Product();

                product.setProductId(rs.getInt("productId"));
                product.setName(rs.getString("productName"));
                product.setDescription(rs.getString("productDescription"));
                product.setPrice(rs.getInt("price"));
                product.setDiscount(rs.getInt("discount"));
                product.setAmount(1);

                return product;
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return null;

    }
}
