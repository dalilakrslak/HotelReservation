package ba.unsa.etf.rpr.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

/**
 * Controller for managing 'Rooms' window
 * @author Dalila Krslak
 */
public class RoomsController {
    public Button homeButtonId;
    public Button aboutusButtonId;
    public Button roomsButtonId;
    public Button contactButtonId;
    public BorderPane roomsPaneId;
    /**
     * Opens 'Home' window
     * @param actionEvent ActionEvent
     * @throws IOException in case of an error
     */
    public void homeOnAction(ActionEvent actionEvent) throws IOException {
        openDialog("Home", "/fxml/home.fxml", new HomeController());
    }
    /**
     * Opens 'About Us' window
     * @param actionEvent ActionEvent
     * @throws IOException in case of an error
     */
    public void aboutusOnAction(ActionEvent actionEvent) throws IOException {
        openDialog("About us", "/fxml/aboutUs.fxml", new AboutUsController());
    }
    /**
     * Opens 'Rooms' window
     * @param actionEvent ActionEvent
     * @throws IOException in case of an error
     */
    public void roomsOnAction(ActionEvent actionEvent) throws IOException {
        openDialog("Rooms", "/fxml/rooms.fxml", new RoomsController());
    }
    /**
     * Opens 'Contact' window
     * @param actionEvent ActionEvent
     * @throws IOException in case of an error
     */
    public void contactOnAction(ActionEvent actionEvent) throws IOException {
        openDialog("Contact", "/fxml/contact.fxml", new ContactController());
    }
    /**
     * Opens a dialog window with the provided FXML file path
     * @param title String for window Title
     * @param file path of the FXML file
     * @param controller Object
     * @throws IOException in case of an error
     */
    private void openDialog(String title, String file, Object controller) throws IOException {
        final Stage homeStage = (Stage) roomsPaneId.getScene().getWindow();
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource(file));
        loader.setController(controller);
        stage.setTitle(title);
        stage.setScene(new Scene(loader.load(), USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        stage.setResizable(false);
        homeStage.hide();
        stage.show();
    }
}
