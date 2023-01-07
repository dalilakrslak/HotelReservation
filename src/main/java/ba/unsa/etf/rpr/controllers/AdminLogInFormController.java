package ba.unsa.etf.rpr.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

public class AdminLogInFormController {
    public TextField usernameId;
    public PasswordField passwordId;
    public Button loginButtonId;
    public Button cancelButtonId;
    public GridPane adminPane;
    public Text greskica;

    @FXML
    public void initialize(){
        usernameId.setFocusTraversable(false);
        passwordId.setFocusTraversable(false);
    }
    public void loginOnAction(ActionEvent actionEvent) throws IOException {
        if(usernameId.getText().isBlank() == true && passwordId.getText().isBlank() == true){
            greskica.setText("Fields can't be empty!");
        }
        else if(usernameId.getText().isBlank() == true && passwordId.getText().isBlank() == false){
            greskica.setText("Please enter your username.");
        }
        else if(usernameId.getText().isBlank() == false && passwordId.getText().isBlank() == true){
            greskica.setText("Please enter your password.");
        }
        else {
            openDialog("Admin", "/fxml/admin.fxml", new AdminController());
        }
    }

    public void cancelOnAction(ActionEvent actionEvent) {
        Stage stage = (Stage) cancelButtonId.getScene().getWindow();
        stage.close();
    }

    private void openDialog(String title, String file, Object controller) throws IOException {
        final Stage homeStage = (Stage) adminPane.getScene().getWindow();
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
