package Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nathalie on 03-05-2016.
 */
public class Receipt
{
    private int receiptId;
    private String dateIssued;
    private int productAmount;
    private double total;
    private boolean paymentType;

    public static List<Employee> employeeList = new ArrayList<Employee>();
    public static List<ImercoCard> imercoCardList = new ArrayList<ImercoCard>();

    public Receipt()
    {}

    public Receipt(int receiptId, String dateIssued, int productAmount, double total, boolean paymentType)
    {
        this.receiptId = receiptId;
        this.dateIssued = dateIssued;
        this.productAmount = productAmount;
        this.total = total;
        this.paymentType = paymentType;
    }


    public int getReceiptId()
    {
        return receiptId;
    }

    public void setReceiptId(int receiptId)
    {
        this.receiptId = receiptId;
    }

    public String getDateIssued()
    {
        return dateIssued;
    }

    public void setDateIssued(String dateIssued)
    {
        this.dateIssued = dateIssued;
    }

    public int getProductAmount()
    {
        return productAmount;
    }

    public void setProductAmount(int productAmount)
    {
        this.productAmount = productAmount;
    }

    public double getTotal()
    {
        return total;
    }

    public void setTotal(double total)
    {
        this.total = total;
    }

    public boolean isPaymentType()
    {
        return paymentType;
    }

    public void setPaymentType(boolean paymentType)
    {
        this.paymentType = paymentType;
    }
}
