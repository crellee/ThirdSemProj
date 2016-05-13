package GUI.GUI_Controller;

import Model.Product;

/**
 * Created by roije on 13/05/2016.
 */
public class FirstProductTest
{
    Product product;

    private static FirstProductTest singleton = new FirstProductTest( );

    /* A private Constructor prevents any other
     * class from instantiating.
     */
    private FirstProductTest(){ }

    /* Static 'instance' method */
    public static FirstProductTest getInstance( ) {
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
