package ba.unsa.etf.rpr.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class LogInFormController {
    public TextField usernameId;
    public PasswordField passwordId;
    public Button loginButtonId;
    public Hyperlink registerId;
    public Button cancelButtonId;
    public GridPane loginFormPaneId;

    @FXML
    public void initialize(){

    }

    public void loginButtonOnAction(ActionEvent actionEvent) throws IOException {
        OpenNewStage o = new OpenNewStage();
        o.openWindow(loginFormPaneId, "home");
    }

    public void registerOnAction(ActionEvent actionEvent) throws IOException {
        OpenNewStage o = new OpenNewStage();
        o.openWindow(loginFormPaneId, "signUpForm");
    }
    public void cancelButtonOnAction(ActionEvent actionEvent) {
        Stage stage = (Stage) cancelButtonId.getScene().getWindow();
        stage.close();
    }
}
