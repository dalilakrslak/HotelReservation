package ba.unsa.etf.rpr.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;
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
        final Stage  loginStage = (Stage) loginFormPaneId.getScene().getWindow();
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/signUpForm.fxml"));
        SignUpFormController controller = new SignUpFormController();
        loader.setController(controller);
        stage.setTitle("Hotel Reservation Registration");
        stage.setScene(new Scene(loader.load(), USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        stage.setResizable(false);
        loginStage.hide();
        stage.show();
    }
    public void cancelButtonOnAction(ActionEvent actionEvent) {
        Stage stage = (Stage) cancelButtonId.getScene().getWindow();
        stage.close();
    }
}
