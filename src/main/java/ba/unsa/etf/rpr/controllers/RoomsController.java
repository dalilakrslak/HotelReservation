package ba.unsa.etf.rpr.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;
public class RoomsController {
    public Button homeButtonId;
    public Button aboutusButtonId;
    public Button roomsButtonId;
    public Button contactButtonId;
    public BorderPane roomsPaneId;
    public void homeOnAction(ActionEvent actionEvent) throws IOException {
        final Stage roomsStage = (Stage) roomsPaneId.getScene().getWindow();
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/home.fxml"));
        HomeController controller = new HomeController();
        loader.setController(controller);
        stage.setTitle("Hotel");
        stage.setScene(new Scene(loader.load(), USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        stage.setResizable(false);
        roomsStage.hide();
        stage.show();
    }

    public void aboutusOnAction(ActionEvent actionEvent) throws IOException {
        final Stage  roomsStage = (Stage) roomsPaneId.getScene().getWindow();
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/aboutUs.fxml"));
        AboutUsController controller = new AboutUsController();
        loader.setController(controller);
        stage.setTitle("Hotel About Us");
        stage.setScene(new Scene(loader.load(), USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        stage.setResizable(false);
        roomsStage.hide();
        stage.show();
    }

    public void roomsOnAction(ActionEvent actionEvent) throws IOException {
        final Stage  roomsStage = (Stage) roomsPaneId.getScene().getWindow();
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/rooms.fxml"));
        RoomsController controller = new RoomsController();
        loader.setController(controller);
        stage.setTitle("Hotel Rooms");
        stage.setScene(new Scene(loader.load(), USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        stage.setResizable(false);
        roomsStage.hide();
        stage.show();
    }

    public void contactOnAction(ActionEvent actionEvent) throws IOException {
        final Stage  roomsStage = (Stage) roomsPaneId.getScene().getWindow();
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/contact.fxml"));
        ContactController controller = new ContactController();
        loader.setController(controller);
        stage.setTitle("Hotel Contact");
        stage.setScene(new Scene(loader.load(), USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        stage.setResizable(false);
        roomsStage.hide();
        stage.show();
    }
}
