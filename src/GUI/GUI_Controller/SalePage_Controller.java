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
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Created by roije on 12/05/2016.
 */
public class SalePage_Controller implements Initializable
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
    TableColumn productName;
    @FXML
    TableColumn desc;
    @FXML
    TableColumn price;
    @FXML
    TableColumn disc;
    @FXML
    TableColumn amount;
    @FXML
    TableView<Product> mainTable;

    ObservableList<Product> allProducts = FXCollections.observableArrayList();

    FirstProduct firstProduct = FirstProduct.getInstance();

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        //When this window opens, we get the first product which was set my HomePage_Controller and add product
        //to the TableView
        Product product = firstProduct.getFirstProduct();
        textField1.setText(Integer.toString(product.getProductId()));
        addToTable(product);
    }


    public void addToTable(Product product)
    {
        prodId.setCellValueFactory(new PropertyValueFactory<Product, Integer>("productId"));
        productName.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));
        desc.setCellValueFactory(new PropertyValueFactory<Model.Product, String>("description"));
        price.setCellValueFactory(new PropertyValueFactory<Model.Product, Double>("price"));
        disc.setCellValueFactory(new PropertyValueFactory<Model.Product, Integer>("discount"));
        amount.setCellValueFactory(new PropertyValueFactory<Model.Product, Integer>("amount"));


        //følgende loop med indestående if sætning tjekker hvis et produkt der bliver tilføjet allerede
        //eksisterer i tabellen. Hvis dette er sandt inkrementeres amount, så varerene ikke bliver tilføjet dobbelt
        for(int i = 0; i < allProducts.size(); i++)
        {
            if(allProducts.get(i).getProductId() == product.getProductId())
            {
                int j = allProducts.get(i).getAmount() + 1;
                product.setAmount(j);
                allProducts.remove(i);
            }
        }
        allProducts.addAll(product);
        mainTable.setItems(allProducts);

        updateTotalAmount();
        updatePaidAmount();
        updateToOwe();
        updateDiscount();

    }


    public void getProductFromDB()
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

                addToTable(product);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void updateTotalAmount()
    {
        totalAmountDoub = 0;
        for (int i = 0; i < allProducts.size(); i++)
        {
            totalAmountDoub += allProducts.get(i).getPrice() * allProducts.get(i).getAmount();
        }

        String doubleToString = Double.toString(totalAmountDoub);
        totalAmountLbl.setText(doubleToString);
    }

    public void updatePaidAmount()
    {
        paidAmountDoub = 0;
        String doubleToString = Double.toString(paidAmountDoub);
        paidAmountLbl.setText(doubleToString);
    }

    public void updateToOwe()
    {
        toOweDoub = 0;
        toOweDoub = totalAmountDoub - paidAmountDoub;
        String doubleToString = Double.toString(toOweDoub);
        toOweLbl.setText(doubleToString);
    }

    public void updateDiscount()
    {
        discountInt = 0;
        String intToString = Integer.toString(discountInt);
        discountLbl.setText(intToString);
    }

    public void loyalityButtonShow() throws IOException
    {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/FXML_LoyalityWindow.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
