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
        OpenNewStage o = new OpenNewStage();
        o.openWindow(roomsPaneId, "home");
    }

    public void aboutusOnAction(ActionEvent actionEvent) throws IOException {
        OpenNewStage o = new OpenNewStage();
        o.openWindow(roomsPaneId, "aboutUs");
    }

    public void roomsOnAction(ActionEvent actionEvent) throws IOException {
        OpenNewStage o = new OpenNewStage();
        o.openWindow(roomsPaneId, "rooms");
    }

    public void contactOnAction(ActionEvent actionEvent) throws IOException {
        OpenNewStage o = new OpenNewStage();
        o.openWindow(roomsPaneId, "contact");
    }
}
