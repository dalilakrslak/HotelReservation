package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.User;
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

/**
 * Controller for Log In Form for admin
 * @author Dalila Krslak
 */
public class AdminLogInFormController {
    public TextField usernameId;
    public PasswordField passwordId;
    public Button loginButtonId;
    public Button cancelButtonId;
    public GridPane adminPane;
    public Text greskica;

    /**
     * Removes focus from fields
     */
    @FXML
    public void initialize(){
        usernameId.setFocusTraversable(false);
        passwordId.setFocusTraversable(false);
        usernameId.textProperty().addListener((obs, oldText, newText) -> {
            usernameId.setFocusTraversable(true);
            passwordId.setFocusTraversable(true);
        });
    }

    /**
     * Checks if fields are empty, if the account exists, if it's an admin and opens 'Admin' window
     * @param actionEvent ActionEvent
     * @throws IOException in case of an error
     */
    public void loginOnAction(ActionEvent actionEvent) throws IOException {
        if(usernameId.getText().isBlank() && passwordId.getText().isBlank()){
            greskica.setText("Fields can't be empty!");
        }
        else if(usernameId.getText().isBlank() && !passwordId.getText().isBlank()){
            greskica.setText("Please enter your username.");
        }
        else if(!usernameId.getText().isBlank() && passwordId.getText().isBlank()){
            greskica.setText("Please enter your password.");
        }
        else {
            String username = usernameId.getText();
            String password = passwordId.getText();
            User admin = DaoFactory.userDao().checkUser(username,password);

            if (admin == null) {
                greskica.setText("Account doesn't exist!");
                usernameId.clear();
                passwordId.clear();
            }
            else if(!admin.isAdmin()){
                greskica.setText("You're not admin!");
            }
            else {
                openDialog("Admin", "/fxml/admin.fxml", new AdminController());
            }
        }
    }

    /**
     * Retrieves the stage of the current window and calls the close() method to close it.
     * @param actionEvent ActionEvent
     */
    public void cancelOnAction(ActionEvent actionEvent) {
        Stage stage = (Stage) cancelButtonId.getScene().getWindow();
        stage.close();
    }

    /**
     * Opens a dialog window with the provided FXML file path
     * @param title String for window Title
     * @param file path of the FXML file
     * @param controller Object
     * @throws IOException in case of an error
     */
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
