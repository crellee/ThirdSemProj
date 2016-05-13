package GUI.GUI_Controller;

import Database.ProductVerifier;
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
     TableColumn prodName;
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

    ObservableList<Model.Product> allProducts = FXCollections.observableArrayList();



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
        prodName.setCellValueFactory(new PropertyValueFactory<Model.Product, String>("name"));
        desc.setCellValueFactory(new PropertyValueFactory<Model.Product, String>("description"));
        price.setCellValueFactory(new PropertyValueFactory<Model.Product, Double>("price"));
        disc.setCellValueFactory(new PropertyValueFactory<Model.Product, Integer>("discount"));
        amount.setCellValueFactory(new PropertyValueFactory<Model.Product, Integer>("amount"));


        ObservableList<Model.Product> data = FXCollections.observableArrayList();

        try
        {
            ResultSet rs = ProductVerifier.tableShow(textField1);
            while(rs.next())
            {
                Model.Product product = new Model.Product();

                product.setProductId(rs.getInt("productId"));
                product.setName(rs.getString("productName"));
                product.setDescription(rs.getString("productDescription"));
                product.setPrice(rs.getInt("price"));
                product.setDiscount(rs.getInt("discount"));
                product.setAmount(1);

                data.add(product);
            }


            /*følgende loop med indestående if sætning tjekker hvis et produkt der bliver tilføjet allerede
            eksisterer i tabellen. Hvis dette er sandt inkrementeres amount, så varerene ikke bliver tilføjet dobbelt*/
            for(int i = 0; i < allProducts.size(); i++)
            {
                if(allProducts.get(i).getProductId() == data.get(0).getProductId())
                {
                    int j = allProducts.get(i).getAmount() + 1;
                    data.get(0).setAmount(j);
                    allProducts.remove(i);
                }
            }
            allProducts.addAll(data);
            mainTable.setItems(allProducts);
        }
        catch(Exception e)
        {

        }
        totalAmount();
        paidAmount();
        toOwe();
        discount();
    }

    public void totalAmount()
    {
        totalAmountDoub = 0;
        for (int i = 0; i < allProducts.size(); i++)
        {
            totalAmountDoub += allProducts.get(i).getPrice() * allProducts.get(i).getAmount();
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
