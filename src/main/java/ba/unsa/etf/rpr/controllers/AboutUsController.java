package ba.unsa.etf.rpr.controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class AboutUsController {
    public Button homeButtonId;
    public Button aboutusButtonId;
    public Button roomsButtonId;
    public Button contactButtonOnAction;
    public BorderPane aboutusPaneId;
    public void homeOnAction(ActionEvent actionEvent) throws IOException {
        OpenNewStage o = new OpenNewStage();
        o.openWindow(aboutusPaneId, "home");
    }
    public void aboutusOnAction(ActionEvent actionEvent) throws IOException {
        OpenNewStage o = new OpenNewStage();
        o.openWindow(aboutusPaneId, "aboutUs");
    }
    public void roomsOnAction(ActionEvent actionEvent) throws IOException {
        OpenNewStage o = new OpenNewStage();
        o.openWindow(aboutusPaneId, "rooms");
    }
    public void contactOnAction(ActionEvent actionEvent) throws IOException {
        OpenNewStage o = new OpenNewStage();
        o.openWindow(aboutusPaneId, "contact");
    }
}
