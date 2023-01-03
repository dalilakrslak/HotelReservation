package ba.unsa.etf.rpr.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;
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
        final Stage  aboutusStage = (Stage) aboutusPaneId.getScene().getWindow();
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/contact.fxml"));
        ContactController controller = new ContactController();
        loader.setController(controller);
        stage.setTitle("Hotel Contact");
        stage.setScene(new Scene(loader.load(), USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        stage.setResizable(false);
        aboutusStage.hide();
        stage.show();
    }
}
