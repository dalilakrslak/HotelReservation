package ba.unsa.etf.rpr.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

public class HomeController {
    public Button homeButtonId;
    public Button aboutUsButtonId;
    public Button roomsButtonId;
    public Button contactButton;
    public Button bookButtonId;
    public BorderPane homePaneId;
    public void homeOnAction(ActionEvent actionEvent) throws IOException {
        openDialog("Home", "/fxml/home.fxml", new HomeController());
    }
    public void aboutUsOnAction(ActionEvent actionEvent) throws IOException {
        openDialog("About us", "/fxml/aboutUs.fxml", new AboutUsController());
    }
    public void roomsOnAction(ActionEvent actionEvent) throws IOException {
        openDialog("Rooms", "/fxml/rooms.fxml", new RoomsController());
    }
    public void contactOnAction(ActionEvent actionEvent) throws IOException {
        openDialog("Contact", "/fxml/contact.fxml", new ContactController());
    }
    public void bookNowOnAction(ActionEvent actionEvent) throws IOException {
        openDialog("Booking", "/fxml/booking.fxml", new BookingController());
    }
    private void openDialog(String title, String file, Object controller) throws IOException {
        final Stage homeStage = (Stage) homePaneId.getScene().getWindow();
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
