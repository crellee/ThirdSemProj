package GUI;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Created by roije on 09/05/2016.
 */
public class FrontPage
{
    private Scene frontPageScene;
    private BorderPane borderPane;
    private Mediator mediator = Mediator.getInstance();


    public Scene getFrontPageScene ()
    {
        return frontPageScene;
    }

    public FrontPage()
    {
        borderPane = new BorderPane();
        frontPageScene = new Scene(borderPane);
        Button button = new Button("Hey");
        borderPane.setCenter(button);
        NextWindow nx = new NextWindow();
        button.setOnAction(e -> mediator.changeScene("nextWindow"));
    }
}
