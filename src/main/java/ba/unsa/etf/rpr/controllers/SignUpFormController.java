package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.dao.DaoFactory;
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

/**
 * Controller for Sign Up Form for guests
 * @author Dalila Krslak
 */
public class SignUpFormController {
    public TextField usernameId;
    public TextField firstNameId;
    public TextField lastNameId;
    public TextField emailId;
    public Text emptyName;
    public Text invalidUsernameId;
    public Text emptyEmail;
    public Text emptyPassword;
    public PasswordField passwordId;
    public Button signupId;
    public Hyperlink loginId;
    public GridPane signUpPane;
    /**
     * Removes focus from fields and checks if username has at least 5 characters.
     */
    @FXML
    public void initialize(){
        firstNameId.setFocusTraversable(false);
        lastNameId.setFocusTraversable(false);
        emailId.setFocusTraversable(false);
        usernameId.setFocusTraversable(false);
        passwordId.setFocusTraversable(false);
        firstNameId.textProperty().addListener((obs, oldText, newText) -> {
            firstNameId.setFocusTraversable(true);
            lastNameId.setFocusTraversable(true);
            emailId.setFocusTraversable(true);
            usernameId.setFocusTraversable(true);
            passwordId.setFocusTraversable(true);
        });
        usernameId.textProperty().addListener((obs, oldValue, newValue)->{
            if(newValue.length()>=5)
                invalidUsernameId.setText("");
            else
                invalidUsernameId.setText("Username must have at least 5 characters!");
        });

    }
    /**
     * Checks if fields are empty, if the account exists and opens 'Home' window
     * @param actionEvent ActionEvent
     * @throws IOException in case of an error
     */
    public void signupButtonOnAction(ActionEvent actionEvent) throws HotelException, IOException {
        if (!usernameId.getText().isBlank() && !passwordId.getText().isBlank() && !firstNameId.getText().isBlank() && !lastNameId.getText().isBlank() && !emailId.getText().isBlank()) {
            String username = usernameId.getText();
            UserDaoSQLImpl u = new UserDaoSQLImpl();
            User user = new User();
            boolean emailOk=checkEmail(emailId.getText());
            if(!emailOk) {
                emptyEmail.setText("Invalid e-mail format.");
            }
            else{
                emptyEmail.setText("");
            }
            boolean flag = DaoFactory.userDao().checkUsername(username);
            if (flag) {
                invalidUsernameId.setText("Username already exists!");
            }
            else {
                user.setFirst_name(firstNameId.getText());
                user.setLast_name(lastNameId.getText());
                user.setEmail(emailId.getText());
                user.setUsername(usernameId.getText());
                user.setPassword(passwordId.getText());
                user.setAdmin(false);
                u.add(user);
                //openDialog("Home", "/fxml/home.fxml", new HomeController());
                openDialog("Hotel Log In", "/fxml/logInForm.fxml", new LogInFormController());
            }
        }
        else{
            if(firstNameId.getText().isBlank()) emptyName.setText("First Name can't be empty!");
            if(lastNameId.getText().isBlank()) emptyName.setText("Last Name can't be empty");
            if(emailId.getText().isBlank()) emptyEmail.setText("E-mail can't be empty!");
            if(usernameId.getText().isBlank())  invalidUsernameId.setText("Username can't be empty!");
            if(passwordId.getText().isBlank() || lastNameId.getText().isBlank()) emptyPassword.setText("Password can't be empty!");
        }
    }
    /**
     * Opens Log In form for guests
     * @param actionEvent ActionEvent
     * @throws IOException in case of an error
     */
    public void loginOnAction(ActionEvent actionEvent) throws IOException {
        openDialog("Hotel Log In", "/fxml/logInForm.fxml", new LogInFormController());
    }
    /**
     * Opens a dialog window with the provided FXML file path
     * @param title String for window Title
     * @param file path of the FXML file
     * @param controller Object
     * @throws IOException in case of an error
     */
    private void openDialog(String title, String file, Object controller) throws IOException {
        final Stage homeStage = (Stage) signUpPane.getScene().getWindow();
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource(file));
        loader.setController(controller);
        stage.setTitle(title);
        stage.setScene(new Scene(loader.load(), USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        stage.setResizable(false);
        homeStage.hide();
        stage.show();
    }
    /**
     *The checkEmail method checks if a given string is a valid email address.
     *The method uses a regular expression to validate the email address.
     *@param emailField The string to be checked if it is a valid email address.
     *@return Returns true if the given string is a valid email address, false otherwise.
     */
    public boolean checkEmail(String emailField){
        String regex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";
        //Compile regular expression to get the pattern
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(emailField);
        return matcher.matches();
    }
}
