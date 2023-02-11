package ba.unsa.etf.rpr.controllers;


import ba.unsa.etf.rpr.business.RoomManager;
import ba.unsa.etf.rpr.dao.ReservationsDaoSQLImpl;
import ba.unsa.etf.rpr.dao.UserDaoSQLImpl;
import ba.unsa.etf.rpr.domain.Reservations;
import ba.unsa.etf.rpr.domain.Room;
import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.HotelException;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import static ba.unsa.etf.rpr.controllers.LogInFormController.user;
import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

/**
 * Controller for form for Booking a room
 * @author Dalila Krslak
 */
public class BookingController {
    public ChoiceBox<String> roomId;
    private ArrayList<String> rooms = new ArrayList<>();
    public DatePicker checkInId;
    public DatePicker checkOutId;
    public GridPane bookingPane;
    /**
     * Constructor which adds choices in ChoiceBox
     */
    public BookingController(){
        rooms.add("Single bed");
        rooms.add("For couples");
        rooms.add("Two beds");
        rooms.add("Family room");
    }

    /**
     * Initializes ChoiceBox for choosing the room
     */
    @FXML
    public void initialize(){
        roomId.setItems(FXCollections.observableList(rooms));
    }

    public void confirmOnAction(ActionEvent actionEvent) throws HotelException {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        LocalDate checkIn = checkInId.getValue();
        LocalDate checkOut = checkOutId.getValue();

        if(checkIn.isBefore(LocalDate.now()) || checkOut.isBefore(LocalDate.now()) || checkOut.isBefore(checkIn) || checkIn.isAfter(checkOut)){
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Invalid date!");
            alert.showAndWait();
        }
        else {
            java.sql.Date checkIn1 = Date.valueOf(checkInId.getValue());
            java.sql.Date checkOut2 = Date.valueOf(checkOutId.getValue());
            String roomDescription = roomId.getValue();
            RoomManager roomManager = new RoomManager();
            Room room = roomManager.getByDescription(roomDescription);
            ReservationsDaoSQLImpl r = new ReservationsDaoSQLImpl();
            Reservations reservations = new Reservations();
            reservations.setCheck_in(checkIn1);
            reservations.setCheck_out(checkOut2);
            reservations.setPerson_id(user);
            reservations.setRoom_id(room);
            r.add(reservations);
            alert.setTitle("Success!");
            alert.setHeaderText(null);
            alert.setContentText("Booked successfully!");
            alert.showAndWait();
        }
    }
    public void backOnAction(ActionEvent actionEvent){

    }
    /**
     * Opens a dialog window with the provided FXML file path
     * @param title String for window Title
     * @param file path of the FXML file
     * @param controller Object
     * @throws IOException in case of an error
     */
    private void openDialog(String title, String file, Object controller) throws IOException {
        final Stage homeStage = (Stage) bookingPane.getScene().getWindow();
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
