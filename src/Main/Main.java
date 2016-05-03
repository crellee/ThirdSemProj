package Main;

import Database.CustomerTable;
import Database.DBCreator;
import Database.EmployeeTable;
import Database.ProductsTable;

/**
 * Created by christianhasselstrom on 21/04/2016.
 */
public class Main
{
    public static void main(String[] args)
    {

        DBCreator.create();
        EmployeeTable.getInstance().createTable();
        ProductsTable.getInstance().createTable();

        CustomerTable customerTable = new CustomerTable();
        customerTable.createTable();

        //hej
        //crellee = noob name
        //blabla
        //testfgfgf
        //hahaha
        //kiejdm
    }
}
