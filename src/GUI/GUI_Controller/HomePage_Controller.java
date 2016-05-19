package GUI.GUI_Controller;

import Database.ProductVerifier;
import Model.Product;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
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
    private Button startSaleBtn;

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

    //Instance of FirstProductTransfer class.
    //This is necessary for getting the first product in the textfield from this controller (HomePage_Controller)
    //into SalePage_Controller, where we will use it, to set into the TableView.
    private FirstProductTransfer firstProductTransfer = FirstProductTransfer.getInstance();


    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        startSaleBtn.setDefaultButton(true);
    }

    public void toSalePage()
    {
        Product product = getFirstProductFromDB();
        firstProductTransfer.setFirstProduct(product);

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

    private Product getFirstProductFromDB()
    {
        try
        {
            ResultSet rs = ProductVerifier.tableShow(textField1);
            while (rs.next())
            {
                Product product = new Product();

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
