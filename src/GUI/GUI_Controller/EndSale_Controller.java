package GUI.GUI_Controller;

import Algorithm.Calculator;
import Database.EmployeeLoginVerifier;
import Database.EndSale;
import Database.ReceiptGenerator;
import Model.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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
    TableView<Product> mainTable;

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

    ObservableList<Product> allProducts = FXCollections.observableArrayList();

    ProductGUI_Intermediary productGUIIntermediary = ProductGUI_Intermediary.getInstance();

    Calculator calculator = new Calculator();

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        prodId.setCellValueFactory(new PropertyValueFactory<Product, Integer>("productId"));
        productName.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));
        desc.setCellValueFactory(new PropertyValueFactory<Model.Product, String>("description"));
        price.setCellValueFactory(new PropertyValueFactory<Model.Product, Double>("price"));
        disc.setCellValueFactory(new PropertyValueFactory<Model.Product, Integer>("discount"));
        amount.setCellValueFactory(new PropertyValueFactory<Model.Product, Integer>("amount"));

        allProducts = productGUIIntermediary.getAllProducts();
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

    public void showEndSale() throws IOException
    {
        Stage endSale = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/FXML_EndSale.fxml"));
        Scene scene = new Scene(root);
        endSale.setScene(scene);
        endSale.show();
    }

    public void doneDeal(ActionEvent event) throws IOException {
        Button clickedBtn = null;
        Object source = event.getSource();
        if (source instanceof Button)
        { //should always be true in your example
            clickedBtn = (Button) source; // that's the button that was clicked
        }

        ReceiptGenerator receiptGenerator = new ReceiptGenerator();
        receiptGenerator.generateSale(allProducts);
        receiptGenerator.generateReceipt(clickedBtn, EmployeeLoginVerifier.getEmployeeNumber(), EndSale.getImercoCard());
        if (!clickedBtn.getText().equals("Forbrugsforening"))
        {
            updateImercoPoints();
        }

        EndSale.resetStatics();
        Main_Controller main_controller = Main_Controller.getInstance();
        main_controller.getStage().close();
        /*
        Stage stage2 = (Stage) totalAmountLbl.getScene().getWindow();
        stage2.close();
        */



        Stage stage = new Stage();
        main_controller.setStage(stage);
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/FXML_FrontPage.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        main_controller.showStage();

    }

    public int updateImercoPoints()
    {
        double totalAmount = calculator.updateTotalAmount(allProducts);

        int total = Algorithm.PointCounter.countPoints((int) totalAmount);

        EndSale.updateImercoPoints(total);

        return total;
    }

}
