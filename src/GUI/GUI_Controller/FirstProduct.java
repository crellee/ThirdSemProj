package GUI.GUI_Controller;

import Model.Product;

/**
 * Created by roije on 13/05/2016.
 * This method used as a intermediary between HomePage_Controller and SalePage_Controller to get the first
 * product, which is transfered from HomePage_Controller textfield to SalePage_Controller textfield.
 */
public class FirstProduct
{
    Product product;

    private static FirstProduct singleton = new FirstProduct( );

    /* A private Constructor prevents any other
     * class from instantiating.
     */
    private FirstProduct(){ }

    /* Static 'instance' method */
    public static FirstProduct getInstance( ) {
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
}
