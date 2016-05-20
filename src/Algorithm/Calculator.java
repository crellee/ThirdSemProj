package Algorithm;

import Model.Product;
import javafx.collections.ObservableList;

/**
 * Created by kristinOlof on 20-05-2016.
 */
public class Calculator
{
    public double updateTotalAmount(ObservableList<Product> allProducts)
    {
        double totalAmountDoub = 0;
        for (int i = 0; i < allProducts.size(); i++)
        {
            totalAmountDoub += allProducts.get(i).getPrice() * allProducts.get(i).getAmount();
        }
        return totalAmountDoub;
    }


    public double updatePaidAmount()
    {
        double paidAmountDoub = 0;
        //totalAmount - paidAmount
        return paidAmountDoub;
    }

    public double updateToOwe(ObservableList<Product> allProducts)
    {
        double toOweDoub = 0;
        toOweDoub = updateTotalAmount(allProducts) - updatePaidAmount();
        return toOweDoub;
    }

    public int updateDiscount(ObservableList<Product> allProducts)
    {
        int discountInt = 0;
        for (int i = 0; i < allProducts.size(); i++)
        {
            discountInt += allProducts.get(i).getDiscount() * allProducts.get(i).getDiscount();
        }
        return discountInt;
    }

}

