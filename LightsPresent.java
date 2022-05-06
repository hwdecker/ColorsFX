import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LightsPresent extends Application
{
    public void start(Stage primaryStage)
    {
        
        /*----------------------------------------------------
         * The scene is create and it is given a title with the 
         * setTitle method. The setScene method is used to set 
         * the scene and it's objects as the scene. The show 
         * method is then called which displays the window.
         * ---------------------------------------------------
         */
        
        Scene scene = new Scene(new LightsPane(), 300, 300);
        
        primaryStage.setTitle("Lights Game");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args)
    {
        launch(args);
    }
}
