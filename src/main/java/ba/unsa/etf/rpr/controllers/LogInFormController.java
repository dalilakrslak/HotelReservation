package ba.unsa.etf.rpr.controllers;


import ba.unsa.etf.rpr.business.UserManager;
import ba.unsa.etf.rpr.dao.DaoFactory;
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

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

/**
 * Controller for Log In Form for guests
 * @author Dalila Krslak
 */
public class LogInFormController {
    public TextField usernameId;
    public PasswordField passwordId;
    public Text greskica;
    public Button loginButtonId;
    public Hyperlink registerId;
    public Button cancelButtonId;
    public GridPane loginFormPaneId;
    public static User user = new User();
    private UserManager userManager = new UserManager();

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
     * Checks if fields are empty, if the account exists and opens 'Home' window
     * @param actionEvent ActionEvent
     * @throws IOException in case of an error
     */
    public void loginButtonOnAction(ActionEvent actionEvent) throws IOException, HotelException {
        if(usernameId.getText().isBlank() && passwordId.getText().isBlank()){
            greskica.setText("Please enter your username and password.");
        }
        else if(usernameId.getText().isBlank() && !passwordId.getText().isBlank()){
            greskica.setText("Please enter your username.");
        }
        else if(!usernameId.getText().isBlank() && passwordId.getText().isBlank()){
            greskica.setText("Please enter your password.");
        }
        else{
            String username = usernameId.getText();
            String password = passwordId.getText();
            User user1 = DaoFactory.userDao().checkUser(username,password);
            if (user1 == null) {
                greskica.setText("Please, enter correct username and password!");
                usernameId.clear();
                passwordId.clear();
            }
            else {
                int logInID = userManager.getLoggedInId(username, password);
                user = userManager.getById(logInID);
                openDialog("Home", "/fxml/home.fxml", new HomeController());
            }
        }
    }

    /**
     * Opens Sign Up form for guests
     * @param actionEvent ActionEvent
     * @throws IOException in case of an error
     */
    public void registerOnAction(ActionEvent actionEvent) throws IOException {
        openDialog("Hotel Sign Up", "/fxml/signUpForm.fxml", new SignUpFormController());
    }
    /**
     * Retrieves the stage of the current window and calls the close() method to close it.
     * @param actionEvent ActionEvent
     */
    public void cancelButtonOnAction(ActionEvent actionEvent) {
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

