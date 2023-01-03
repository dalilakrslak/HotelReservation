package ba.unsa.etf.rpr.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import ba.unsa.etf.rpr.controllers.OpenNewStage;

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
        OpenNewStage o = new OpenNewStage();
        o.openWindow(homePaneId, "home");
    }
    public void aboutUsOnAction(ActionEvent actionEvent) throws IOException {
        OpenNewStage o = new OpenNewStage();
        o.openWindow(homePaneId, "aboutUs");
    }
    public void roomsOnAction(ActionEvent actionEvent) throws IOException {
        OpenNewStage o = new OpenNewStage();
        o.openWindow(homePaneId, "rooms");
    }
    public void contactOnAction(ActionEvent actionEvent) throws IOException {
        OpenNewStage o = new OpenNewStage();
        o.openWindow(homePaneId, "contact");
    }
    public void bookNowOnAction(ActionEvent actionEvent) throws IOException {
        OpenNewStage o = new OpenNewStage();
        o.openWindow(homePaneId, "booking");
    }
}
