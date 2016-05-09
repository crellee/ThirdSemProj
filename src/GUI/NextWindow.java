package GUI;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

/**
 * Created by roije on 09/05/2016.
 */
public class NextWindow
{
    private Scene nextScene;
    private BorderPane borderPane;

    public Scene getNextPageScene ()
    {
        return nextScene;
    }

    public NextWindow()
    {
        borderPane = new BorderPane();
        nextScene = new Scene(borderPane);
        Button button = new Button("Hey2");
        borderPane.setCenter(button);

    }
}
