package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.dao.AbstractDao;
import ba.unsa.etf.rpr.dao.UserDaoSQLImpl;
import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.HotelException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;
public class LogInFormController {
    public TextField usernameId;
    public PasswordField passwordId;
    public Text greskica;
    public Button loginButtonId;
    public Hyperlink registerId;
    public Button cancelButtonId;
    public GridPane loginFormPaneId;

    // LogInFormController controller = new LogInFormController();
    @FXML
    public void initialize(){
        usernameId.setFocusTraversable(false);
        passwordId.setFocusTraversable(false);
    }

    public void loginButtonOnAction(ActionEvent actionEvent) throws IOException {
        if(usernameId.getText().isBlank() == true && passwordId.getText().isBlank() == true){
            greskica.setText("Please enter your username and password.");
        }
        else if(usernameId.getText().isBlank() == true && passwordId.getText().isBlank() == false){
            greskica.setText("Please enter your username.");
        }
        else if(usernameId.getText().isBlank() == false && passwordId.getText().isBlank() == true){
            greskica.setText("Please enter your password.");
        }
        else{
            openDialog("Home", "/fxml/home.fxml", new HomeController());

        }
    }


    public void registerOnAction(ActionEvent actionEvent) throws IOException {
        openDialog("Hotel Sign Up", "/fxml/signUpForm.fxml", new SignUpFormController());
    }
    public void cancelButtonOnAction(ActionEvent actionEvent) {
        Stage stage = (Stage) cancelButtonId.getScene().getWindow();
        stage.close();
    }
    private void openDialog(String title, String file, Object controller) throws IOException {
        final Stage homeStage = (Stage) loginFormPaneId.getScene().getWindow();
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

