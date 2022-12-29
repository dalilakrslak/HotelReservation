package ba.unsa.etf.rpr.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class SignUpFormController {
    public TextField usernameId;
    public Text invalidUsernameId;
    @FXML
    public void initialize(){
        usernameId.textProperty().addListener((obs, oldValue, newValue)->{
            if(newValue.length()>=5)
                invalidUsernameId.setText("");
            else
                invalidUsernameId.setText("Username must have atleast 5 characters!");
        });
    }
}
