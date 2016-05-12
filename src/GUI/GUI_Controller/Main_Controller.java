package GUI.GUI_Controller;

import javafx.stage.Stage;

/**
 * Created by roije on 12/05/2016.
 */
public class Main_Controller
{
    private static Main_Controller singleton = new Main_Controller( );

    /* A private Constructor prevents any other
     * class from instantiating.
     */
    private Main_Controller(){ }

    /* Static 'instance' method */
    public static Main_Controller getInstance( ) {
        return singleton;
    }

    Stage thisStage;

    public void setStage (Stage stage){
        thisStage = stage;
    }

    public Stage getStage()
    {
        return this.thisStage;
    }

    public void showStage()
    {
        thisStage.show();
    }
}
