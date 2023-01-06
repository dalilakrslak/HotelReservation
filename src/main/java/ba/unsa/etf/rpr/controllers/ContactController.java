package ba.unsa.etf.rpr.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

public class ContactController {
    public BorderPane contactPaneId;
    public Button chomeButtonId;
    public Button caboutusButtonId;
    public Button croomsButtonId;
    public Button ccontactButtonId;
    public void chomeOnAction(ActionEvent actionEvent) throws IOException {
        openDialog("Home", "/fxml/home.fxml", new HomeController());
    }
    public void caboutusOnAction(ActionEvent actionEvent) throws IOException {
        openDialog("About us", "/fxml/aboutUs.fxml", new AboutUsController());
    }
    public void croomsOnAction(ActionEvent actionEvent) throws IOException {
        openDialog("Rooms", "/fxml/rooms.fxml", new RoomsController());
    }
    public void ccontactOnAction(ActionEvent actionEvent) throws IOException {
        openDialog("Contact", "/fxml/contact.fxml", new ContactController());
    }
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
