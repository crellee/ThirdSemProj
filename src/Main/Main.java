package Main;

import Database.*;
import Database.DBCreator;
import Database.EmployeeTable;
import Database.ProductsTable;
import Database.ReceiptTable;
import GUI.GUI_Controller.Main_Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

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
        CustomerTable.getInstance().createTable();
        ImercoCardTable.getInstance().createTable();
        ReceiptTable.getInstance().createTable();
        SalesTable.getInstance().createTable();

        /*
            Dummy info is created when the program closes after running for the first time.
            After first run of program, comment it out so we dont get duplicates in database.
         */
        //DummieInfo.getInstance().customerInfo();

    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        URL location = getClass().getResource("/GUI/FXML_FrontPage.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(location);
        fxmlLoader.setBuilderFactory(new JavaFXBuilderFactory());
        Parent root = (Parent) fxmlLoader.load(location.openStream());
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        Main_Controller mainController = Main_Controller.getInstance();
        mainController.setStage(primaryStage);
        mainController.showStage();

    }
}
