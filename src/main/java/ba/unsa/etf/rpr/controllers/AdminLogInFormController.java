package ba.unsa.etf.rpr.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class AdminLogInFormController {
    public TextField usernameId;
    public PasswordField passwordId;
    public Button loginButtonId;
    public Button cancelButtonId;

    public void loginOnAction(ActionEvent actionEvent) {
    }

    public void cancelOnAction(ActionEvent actionEvent) {
        Stage stage = (Stage) cancelButtonId.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void initialize(){
        usernameId.setFocusTraversable(false);
        passwordId.setFocusTraversable(false);
    }
}
