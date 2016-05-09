package GUI;

import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by christianhasselstrom on 09/05/2016.
 */
public class Mediator
{
    private Scene frontPage, homePage, nextWindow;
    private Stage stage;
    private static Mediator instance;

    public static synchronized Mediator getInstance()
    {
        if(instance == null)
        {
            instance = new Mediator();
        }
        return instance;
    }

    //Setter for the stage
    public void setStage(Stage newStage)
    {
        this.stage = newStage;
    }

    //Setter for frontPage
    public void setFrontPage(Scene newFrontPage)
    {
        this.frontPage = newFrontPage;
        setStageConfig(frontPage, "Front Page");
    }

    //Setter for homePage
    public void setHomePage(Scene newHomePage)
    {
        this.homePage = newHomePage;
    }

    private void setStageConfig(Scene scene, String heading)
    {
        stage.setScene(scene);
        stage.setTitle(heading);
        stage.setResizable(true);
        stage.setMaximized(true);
        stage.show();
    }

    public void changeScene(String sceneName)
    {
        switch (sceneName)
        {
            case "frontPage":
                setStageConfig(frontPage, "Front Page");
                break;
            case "homePage":
                setStageConfig(homePage, "Home Page");
                break;
            case "nextWindow":
                setStageConfig(nextWindow, "gblbc");
        }
    }
}
