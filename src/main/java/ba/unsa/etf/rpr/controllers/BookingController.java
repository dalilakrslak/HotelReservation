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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;

import java.sql.Date;
import java.util.ArrayList;
import static ba.unsa.etf.rpr.controllers.LogInFormController.user;
/**
 * Controller for form for Booking a room
 * @author Dalila Krslak
 */
public class BookingController {
    public ChoiceBox<String> roomId;
    private ArrayList<String> rooms = new ArrayList<>();
    public DatePicker checkInId;
    public DatePicker checkOutId;
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
        java.sql.Date checkIn = Date.valueOf(checkInId.getValue());
        java.sql.Date checkOut = Date.valueOf(checkOutId.getValue());
        String roomDescription = roomId.getValue();
        RoomManager roomManager = new RoomManager();
        Room room = roomManager.getByDescription(roomDescription);
        ReservationsDaoSQLImpl r = new ReservationsDaoSQLImpl();
        Reservations reservations = new Reservations();
        reservations.setCheck_in(checkIn);
        reservations.setCheck_out(checkOut);
        reservations.setPerson_id(user);
        reservations.setRoom_id(room);
        r.add(reservations);
    }

}
