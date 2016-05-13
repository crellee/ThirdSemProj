package GUI.GUI_Controller;

import Database.ProductVerifier;
import Model.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

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
    TableColumn desc;
    @FXML
    TableColumn price;
    @FXML
    TableColumn disc;
    @FXML
    TableColumn amount;
    @FXML
    TableView<Product> mainTable;

    ObservableList<Product> data2 = FXCollections.observableArrayList();

    FirstProductTest firstProductTest = FirstProductTest.getInstance();

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        Product product = firstProductTest.getFirstProduct();
        textField1.setText(Integer.toString(product.getProductId()));
        addToTable(product);
    }


    public void addToTable(Product product)
    {
        prodId.setCellValueFactory(new PropertyValueFactory<Product, Integer>("productId"));
        desc.setCellValueFactory(new PropertyValueFactory<Model.Product, String>("description"));
        price.setCellValueFactory(new PropertyValueFactory<Model.Product, Double>("price"));
        disc.setCellValueFactory(new PropertyValueFactory<Model.Product, Integer>("discount"));
        amount.setCellValueFactory(new PropertyValueFactory<Model.Product, Integer>("amount"));


        ObservableList<Model.Product> data = FXCollections.observableArrayList();
        data.addAll(product);


            //følgende loop med indestående if sætning tjekker hvis et produkt der bliver tilføjet allerede
            //eksisterer i tabellen. Hvis dette er sandt inkrementeres amount, så varerene ikke bliver tilføjet dobbelt
            for(int i = 0; i < data2.size(); i++)
            {
                if(data2.get(i).getProductId() == data.get(0).getProductId())
                {
                    int j = data2.get(i).getAmount() + 1;
                    data.get(0).setAmount(j);
                    data2.remove(i);
                }
            }
            data2.addAll(data);
            mainTable.setItems(data2);
        totalAmount();
        paidAmount();
        toOwe();
        discount();

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

    public void totalAmount()
    {
        totalAmountDoub = 0;
        for (int i = 0; i < data2.size(); i++)
        {
            totalAmountDoub += data2.get(i).getPrice() * data2.get(i).getAmount();
        }

        String doubleToString = Double.toString(totalAmountDoub);
        totalAmountLbl.setText(doubleToString);
    }

    public void paidAmount()
    {
        paidAmountDoub = 0;
        String doubleToString = Double.toString(paidAmountDoub);
        paidAmountLbl.setText(doubleToString);
    }

    public void toOwe()
    {
        toOweDoub = 0;
        toOweDoub = totalAmountDoub - paidAmountDoub;
        String doubleToString = Double.toString(toOweDoub);
        toOweLbl.setText(doubleToString);
    }

    public void discount()
    {
        discountInt = 0;
        String intToString = Integer.toString(discountInt);
        discountLbl.setText(intToString);
    }

}
