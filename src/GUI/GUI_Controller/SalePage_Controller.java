package GUI.GUI_Controller;

import Algorithm.Calculator;
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
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
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
    Stage loyalityStage = new Stage();

    @FXML
    private Button paymentBtn;

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
    private Label pointLabel;

    static int customerPoints;

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

    ProductGUI_Intermediary productGUIIntermediary = ProductGUI_Intermediary.getInstance();

    Calculator calculator = new Calculator();

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        //When this window opens, we get the first product which was set my HomePage_Controller and add product
        //to the TableView
        Product product = productGUIIntermediary.getFirstProduct();
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

        double totalAmount = calculator.updateTotalAmount(allProducts);
        totalAmountLbl.setText(Double.toString(totalAmount));

        int discountAmount = calculator.updateDiscount(allProducts);
        discountLbl.setText(Integer.toString(discountAmount));

        double toOweAmount = calculator.updateToOwe(allProducts);
        toOweLbl.setText(Double.toString(toOweAmount));

        double paidAmount = calculator.updatePaidAmount();
        paidAmountLbl.setText(Double.toString(paidAmount));
    }

    @FXML
    public void getProductFromDB(KeyEvent event)
    {
        if (event.getCode().equals(KeyCode.ENTER))
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
            } catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
    }

    public void loyalityButtonShow() throws IOException
    {
        Loyality_Controller loyality_controller = new Loyality_Controller();
        loyality_controller.showLoyalityWindow();
        /*
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/FXML_LoyalityWindow.fxml"));
        Scene scene = new Scene(root);
        loyalityStage.setScene(scene);
        loyalityStage.show();
        */
    }

    public void showEndSale()
    {
        productGUIIntermediary.setAllProducts(allProducts);
        Main_Controller main_controller = Main_Controller.getInstance();
        Parent root = null;
        try
        {
            root = FXMLLoader.load(getClass().getResource("/GUI/FXML_EndSale.fxml"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        Stage homeScreenStage = main_controller.getStage();
        Scene scene = new Scene(root);
        homeScreenStage.setScene(scene);
        main_controller.showStage();
    }


    public void clearTable()
    {
        allProducts.clear();
        mainTable.setItems(allProducts);

        double totalAmount = calculator.updateTotalAmount(allProducts);
        totalAmountLbl.setText(Double.toString(totalAmount));

        int discountAmount = calculator.updateDiscount(allProducts);
        discountLbl.setText(Integer.toString(discountAmount));

        double toOweAmount = calculator.updateToOwe(allProducts);
        toOweLbl.setText(Double.toString(toOweAmount));

        double paidAmount = calculator.updatePaidAmount();
        paidAmountLbl.setText(Double.toString(paidAmount));
    }

    public void clearLine()
    {
        Product product = mainTable.getSelectionModel().getSelectedItem();

        int productId = product.getProductId();
        for(int i = 0; i < allProducts.size(); i++)
        {
            if (allProducts.get(i).getProductId() == productId)
            {
                allProducts.remove(i);
            }
        }
        mainTable.setItems(allProducts);

        double totalAmount = calculator.updateTotalAmount(allProducts);
        totalAmountLbl.setText(Double.toString(totalAmount));

        int discountAmount = calculator.updateDiscount(allProducts);
        discountLbl.setText(Integer.toString(discountAmount));

        double toOweAmount = calculator.updateToOwe(allProducts);
        toOweLbl.setText(Double.toString(toOweAmount));

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
}
