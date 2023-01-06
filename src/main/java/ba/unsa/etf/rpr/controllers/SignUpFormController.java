package ba.unsa.etf.rpr.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class SignUpFormController {
    public TextField usernameId;
    public TextField firstNameId;
    public TextField lastNameId;
    public TextField emailId;
    public Text invalidUsernameId;
    public PasswordField passwordId;
    @FXML
    public void initialize(){
        firstNameId.setFocusTraversable(false);
        lastNameId.setFocusTraversable(false);
        emailId.setFocusTraversable(false);
        usernameId.setFocusTraversable(false);
        passwordId.setFocusTraversable(false);
        usernameId.textProperty().addListener((obs, oldValue, newValue)->{
            if(newValue.length()>=5)
                invalidUsernameId.setText("");
            else
                invalidUsernameId.setText("Username must have atleast 5 characters!");
        });
    }
}
