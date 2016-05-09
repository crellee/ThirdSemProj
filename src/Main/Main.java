package Main;

import Database.*;
import Database.DBCreator;
import Database.EmployeeTable;
import Database.ProductsTable;
import Database.ReceiptTable;
import GUI.FrontPage;
import GUI.Mediator;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by christianhasselstrom on 21/04/2016.
 */
public class Main extends Application
{
    public static void main(String[] args)
    {
        launch(args);
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
        ReceiptTable.getInstance().createTable();

        CustomerTable.getInstance().createTable();
        ImercoCardTable.getInstance().createTable();
        ReceiptTable.getInstance().createTable();
        SalesTable.getInstance().createTable();




    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        Mediator mediator = Mediator.getInstance();
        mediator.setStage(primaryStage);
        FrontPage frontPage = new FrontPage();
        mediator.setFrontPage(frontPage.getFrontPageScene());
    }
}
