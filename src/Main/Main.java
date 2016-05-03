package Main;

import Database.*;

/**
 * Created by christianhasselstrom on 21/04/2016.
 */
public class Main
{
    public static void main(String[] args)
    {
        /*
        rækkefølgen af hvordan tabellerne bliver oprettet er vigtig!
        Employee
        Products
        Customer
        ImercoCard
        Receipt
        Sales
         */

        DBCreator.create();

        EmployeeTable.getInstance().createTable();
        ProductsTable.getInstance().createTable();
        CustomerTable.getInstance().createTable();
        ImercoCardTable.getInstance().createTable();
        ReceiptTable.getInstance().createTable();
        SalesTable.getInstance().createTable();

    }
}
