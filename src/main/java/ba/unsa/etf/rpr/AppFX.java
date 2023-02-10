package ba.unsa.etf.rpr;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

/**
 * class that extends Application
 * @author Dalila Krslak
 */
public class AppFX extends Application
{
    /**
     * Opens First Page window
     * @param primaryStage Stage
     * @throws Exception in case of an error
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/firstPage.fxml"));
        primaryStage.setTitle("Hello!");
        primaryStage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    /**
     * Main runnable method
     * @param args
     */
    public static void main( String[] args )
    {
        launch(args);
    }
}
