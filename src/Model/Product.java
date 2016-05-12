package Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nathalie on 03-05-2016.
 */
public class Product
{
    private int productId;
    private String name;
    private String description;
    private double price;
    private double discount;
    private int amount;

    //?Instanciate via database?
    public static List<Product> productArrayList = new ArrayList<>();

    //Dummy constructor
    public Product()
    {}

    //Constructor
    public Product(int productId, String name, String description, double price, double discount)
    {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.discount = discount;
        this.amount = amount;
    }


    public int getProductId()
    {
        return productId;
    }

    public void setProductId(int productId)
    {
        this.productId = productId;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public double getDiscount()
    {
        return discount;
    }

    public void setDiscount(double discount)
    {
        this.discount = discount;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
