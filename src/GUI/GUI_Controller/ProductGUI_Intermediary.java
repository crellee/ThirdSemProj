package GUI.GUI_Controller;

import Model.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Created by roije on 13/05/2016.
 * This method used as a intermediary between HomePage_Controller and SalePage_Controller to get the first
 * product, which is transfered from HomePage_Controller textfield to SalePage_Controller textfield.
 */
public class ProductGUI_Intermediary
{
    Product product;
    ObservableList<Product> allProducts = FXCollections.observableArrayList();


    private static ProductGUI_Intermediary singleton = new ProductGUI_Intermediary( );

    /* A private Constructor prevents any other
     * class from instantiating.
     */
    private ProductGUI_Intermediary(){ }

    /* Static 'instance' method */
    public static ProductGUI_Intermediary getInstance( ) {
        return singleton;
    }

    public Product getFirstProduct()
    {
        return  this.product;
    }

    public void setFirstProduct(Product product)
    {
        if (product != null)
        {
            this.product = product;
        }
    }

    public ObservableList<Product> getAllProducts() {
        return allProducts;
    }

    public void setAllProducts(ObservableList<Product> allProducts) {
        this.allProducts = allProducts;
    }

    public void addOneProduct(Product product)
    {
        this.allProducts.add(product);
    }
}
