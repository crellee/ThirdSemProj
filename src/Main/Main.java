package Main;

import Database.DBCreator;
import Database.EmployeeTable;

/**
 * Created by christianhasselstrom on 21/04/2016.
 */
public class Main
{
    public static void main(String[] args)
    {

        DBCreator.create();
        ProductsTable pr = new ProductsTable();
        pr.createTable();
        EmployeeTable employeeTable = new EmployeeTable();
        employeeTable.createTable();

        //hej
        //crellee = noob name
        //blabla
        //testfgfgf
        //hahaha
        //kiejdm
    }
}
