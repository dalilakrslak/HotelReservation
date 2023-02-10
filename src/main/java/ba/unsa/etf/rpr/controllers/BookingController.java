package ba.unsa.etf.rpr.controllers;


import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;

import java.util.ArrayList;
/**
 * Controller for form for Booking a room
 * @author Dalila Krslak
 */
public class BookingController {
    public ChoiceBox<String> roomId;
    private ArrayList<String> rooms = new ArrayList<>();

    /**
     * Constructor which adds choices in ChoiceBox
     */
    public BookingController(){
        rooms.add("Single bed");
        rooms.add("Room for couple");
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

}
