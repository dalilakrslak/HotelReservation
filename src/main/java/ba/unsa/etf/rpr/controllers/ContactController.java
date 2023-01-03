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
        OpenNewStage o = new OpenNewStage();
        o.openWindow(contactPaneId, "home");
    }

    public void caboutusOnAction(ActionEvent actionEvent) throws IOException {
        OpenNewStage o = new OpenNewStage();
        o.openWindow(contactPaneId, "aboutUs");
    }

    public void croomsOnAction(ActionEvent actionEvent) throws IOException {
        OpenNewStage o = new OpenNewStage();
        o.openWindow(contactPaneId, "rooms");
    }

    public void ccontactOnAction(ActionEvent actionEvent) throws IOException {
        OpenNewStage o = new OpenNewStage();
        o.openWindow(contactPaneId, "contact");
    }
}
