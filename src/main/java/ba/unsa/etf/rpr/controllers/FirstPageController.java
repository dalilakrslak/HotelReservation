package ba.unsa.etf.rpr.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

/**
 * Controller for the first window of the App
 * @author Dalila Krslak
 */
public class FirstPageController {
    public Button adminId;
    public Button guestId;

    /**
     * Opens Log In for admin
     * @param actionEvent ActionEvent
     * @throws IOException in case of an error
     */
    public void adminOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/adminLogInForm.fxml"));
        AdminLogInFormController controller = new AdminLogInFormController();
        loader.setController(controller);
        stage.setTitle("Hotel Reservation Admin Log In");
        stage.setScene(new Scene(loader.load(), USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        stage.setResizable(false);
        stage.show();
    }

    /**
     * Opens Log In for guests
     * @param actionEvent ActionEvent
     * @throws IOException in case of an error
     */
    public void guestOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/logInForm.fxml"));
        LogInFormController controller = new LogInFormController();
        loader.setController(controller);
        stage.setTitle("Hotel Reservation Guest Log In");
        stage.setScene(new Scene(loader.load(), USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        stage.setResizable(false);
        stage.show();
    }
}
