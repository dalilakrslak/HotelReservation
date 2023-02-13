package ba.unsa.etf.rpr.controllers;


import ba.unsa.etf.rpr.business.RoomManager;
import ba.unsa.etf.rpr.dao.ReservationsDaoSQLImpl;
import ba.unsa.etf.rpr.domain.Reservations;
import ba.unsa.etf.rpr.domain.Room;
import ba.unsa.etf.rpr.exceptions.HotelException;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
    public Label priceLabel;
    private final RoomManager roomManager = new RoomManager();
    private final List<Room> room = roomManager.getAll();
    /**
     * Constructor which adds choices in ChoiceBox
     * @throws HotelException in case of an error
     */
    public BookingController() throws HotelException {
        for(Room r: room){
            rooms.add(r.getDescription());
        }
    }

    /**
     * Initializes ChoiceBox for choosing the room
     */
    @FXML
    public void initialize(){
        roomId.setItems(FXCollections.observableList(rooms));
        initializeRoomChoice();
        initializeDatePicker();
    }

    /**
     * method for initialization of DatePicker
     */
    private void initializeDatePicker() {
        final Callback<DatePicker, DateCell> dayCellFactory = new Callback<DatePicker, DateCell>() {
            @Override
            public DateCell call(final DatePicker datePicker) {
                return new DateCell() {
                    @Override
                    public void updateItem(LocalDate item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item.isBefore(LocalDate.now())) {
                            setDisable(true);
                            setStyle("-fx-background-color: #B6B6B4;");
                        }
                    }
                };
            }
        };
        checkInId.setDayCellFactory(dayCellFactory);
        final Callback<DatePicker, DateCell> dayCellFactory2 = new Callback<DatePicker, DateCell>() {
            @Override
            public DateCell call(final DatePicker datePicker) {
                return new DateCell() {
                    @Override
                    public void updateItem(LocalDate item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item.isBefore(LocalDate.now()) || item.isBefore(checkInId.getValue())) {
                            setDisable(true);
                            setStyle("-fx-background-color: #B6B6B4;");
                        }
                    }
                };
            }
        };
        checkOutId.setDayCellFactory(dayCellFactory2);
    }

    /**
     * method to initialize room price
     */
    public void initializeRoomChoice(){
        roomId.getSelectionModel().selectedIndexProperty().addListener((observable, oldValue, newValue ) -> {
            try {
                String name = rooms.get(Integer.parseInt(newValue.toString()));
                Room r = roomManager.getByDescription(name);
                priceLabel.setText(r.getPrice());
            } catch (HotelException e) {
                throw new RuntimeException(e);
            }
        });
    }
    /**
     * Method for making a reservation and inserting it in database
     * @param actionEvent ActionEvent
     * @throws HotelException in case of an error
     */
    public void confirmOnAction(ActionEvent actionEvent) throws HotelException {
        if(roomId.getValue()==null || checkInId.getValue()==null  || checkOutId.getValue()==null){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setHeaderText("Missing fields");
            alert.setContentText("You have to fill in all fields in order to book an appointment!");
            alert.showAndWait();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
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

    /**
     * goes back to Home window
     * @throws IOException in case of an error
     */
    public void backOnAction() throws IOException {
        openDialog("Home", "/fxml/home.fxml", new HomeController());
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
