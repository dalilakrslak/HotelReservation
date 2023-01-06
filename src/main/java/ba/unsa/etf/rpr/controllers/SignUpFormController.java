package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.dao.UserDaoSQLImpl;
import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.HotelException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static ba.unsa.etf.rpr.dao.AbstractDao.getConnection;

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

    public void signupButtonOnAction(ActionEvent actionEvent) throws HotelException {
        if (usernameId.getText().isBlank() == false && passwordId.getText().isBlank() == false && firstNameId.getText().isBlank()==false && lastNameId.getText().isBlank()==false && emailId.getText().isBlank() == false) {
            String username = usernameId.getText();
            UserDaoSQLImpl u = new UserDaoSQLImpl();
            User user = new User();
            boolean flag = checkUsername(username);
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
    public boolean checkUsername(String username) {
        String sql = "SELECT * FROM USER WHERE username = ?";
        try {
            PreparedStatement s=getConnection().prepareStatement(sql);
            s.setString(1, username);
            ResultSet r = s.executeQuery();
            while(r.next()){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
