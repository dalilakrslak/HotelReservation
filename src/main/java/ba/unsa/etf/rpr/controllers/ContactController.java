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
 * Controller for managing 'Contact' window
 * @author Dalila Krslak
 */
public class ContactController {
    public BorderPane contactPaneId;
    public Button chomeButtonId;
    public Button caboutusButtonId;
    public Button croomsButtonId;
    public Button ccontactButtonId;
    /**
     * Opens 'Home' window
     * @param actionEvent ActionEvent
     * @throws IOException in case of an error
     */
    public void chomeOnAction(ActionEvent actionEvent) throws IOException {
        openDialog("Home", "/fxml/home.fxml", new HomeController());
    }
    /**
     * Opens 'About Us' window
     * @param actionEvent ActionEvent
     * @throws IOException in case of an error
     */
    public void caboutusOnAction(ActionEvent actionEvent) throws IOException {
        openDialog("About us", "/fxml/aboutUs.fxml", new AboutUsController());
    }
    /**
     * Opens 'Rooms' window
     * @param actionEvent ActionEvent
     * @throws IOException in case of an error
     */
    public void croomsOnAction(ActionEvent actionEvent) throws IOException {
        openDialog("Rooms", "/fxml/rooms.fxml", new RoomsController());
    }
    /**
     * Opens 'Contact' window
     * @param actionEvent ActionEvent
     * @throws IOException in case of an error
     */
    public void ccontactOnAction(ActionEvent actionEvent) throws IOException {
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
        final Stage homeStage = (Stage) contactPaneId.getScene().getWindow();
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
