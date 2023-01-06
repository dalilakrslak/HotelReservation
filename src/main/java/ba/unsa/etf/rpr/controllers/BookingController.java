package ba.unsa.etf.rpr.controllers;


import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;

import java.util.ArrayList;

public class BookingController {
    public ChoiceBox<String> roomId;
    private ArrayList<String> rooms = new ArrayList<>();

    public BookingController(){
        rooms.add("Single bed");
        rooms.add("Room for couples");
        rooms.add("Two bed");
        rooms.add("Family room");
    }
    @FXML
    public void initialize(){
        roomId.setItems(FXCollections.observableList(rooms));
    }

}
