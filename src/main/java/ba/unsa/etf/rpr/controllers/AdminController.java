package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.ReservationsManager;
import ba.unsa.etf.rpr.business.RoomManager;
import ba.unsa.etf.rpr.business.UserManager;
import ba.unsa.etf.rpr.domain.Reservations;
import ba.unsa.etf.rpr.domain.Room;
import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.HotelException;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;

import java.sql.Date;

import static java.lang.String.valueOf;

/**
 * Controller for Admin window
 * @author Dalila Krslak
 */

public class AdminController {
    public TableColumn<User, Integer> userIdColumn;
    public TableColumn<User, String> firstNameColumn;
    public TableColumn<User, String> lastNameColumn;
    public TableColumn<User, String> emailColumn;
    public TableColumn<User, String> passwordColumn;
    public TableColumn<User, String> usernameColumn;
    public TableColumn<User, Boolean> adminColumn;
    public TableView userTableID;
    public TableColumn<Room, Integer> roomIdColumn;
    public TableColumn<Room, String> descriptionColumn;
    public TableColumn<Room, String> priceColumn;
    public TableView roomTableID;
    public TableColumn<Reservations, Integer> reservationIdColumn;
    public TableColumn<Reservations, Date> checkInColumn;
    public TableColumn<Reservations, Date> checkOutColumn;
    public TableColumn<Reservations, String> personColumn;
    public TableColumn<Reservations, String> roomColumn;
    public TableView<Reservations> reservationsTableID;
    public BorderPane tablePaneID;
    UserManager userManager = new UserManager();
    RoomManager roomManager = new RoomManager();
    ReservationsManager reservationsManager = new ReservationsManager();

    /**
     *Initializes the userTable, roomTable and reservationsTable with values from database for users, rooms and reservations.
     */
    @FXML
    public void initialize() {
        userIdColumn.setCellValueFactory(cellData -> {
            User user = cellData.getValue();
            return new SimpleIntegerProperty(user.getId()).asObject();
        });
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<User, String>("first_name"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<User, String>("last_name"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<User, String>("email"));
        usernameColumn.setCellValueFactory(new PropertyValueFactory<User, String>("username"));
        passwordColumn.setCellValueFactory(new PropertyValueFactory<User, String>("password"));
        adminColumn.setCellValueFactory(new PropertyValueFactory<User, Boolean>("admin"));
        refreshUser();

        roomIdColumn.setCellValueFactory(cellData ->{
            Room room = cellData.getValue();
            return new SimpleIntegerProperty(room.getId()).asObject();
        });
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<Room, String>("description"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<Room, String>("price"));
        refreshRoom();

        reservationIdColumn.setCellValueFactory(cellData ->{
            Reservations reservations = cellData.getValue();
            return new SimpleIntegerProperty(reservations.getId()).asObject();
        });
        checkInColumn.setCellValueFactory(new PropertyValueFactory<Reservations, Date>("check_in"));
        checkOutColumn.setCellValueFactory(new PropertyValueFactory<Reservations, Date>("check_out"));
        roomColumn.setCellValueFactory(param -> new SimpleStringProperty((valueOf(param.getValue().getRoom_id().getId()))));
        personColumn.setCellValueFactory(param -> new SimpleStringProperty((valueOf(param.getValue().getPerson_id().getId()))));
        refreshReservations();
    }
    /**
     * Refreshes user table with current data
     */
    void refreshUser(){
        try{
            userTableID.setItems(FXCollections.observableList(userManager.getAll()));
            userTableID.refresh();
        } catch (HotelException e){
            e.printStackTrace();
        }
    }
    /**
     * Refreshes room table with current data
     */
    void refreshRoom(){
        try{
            roomTableID.setItems(FXCollections.observableList(roomManager.getAll()));
            roomTableID.refresh();
        } catch (HotelException e){
            e.printStackTrace();
        }
    }

    /**
     * Refreshes reservations table with current data
     */
    void refreshReservations(){
        try{
            reservationsTableID.setItems(FXCollections.observableList(reservationsManager.getAll()));
            reservationsTableID.refresh();
        } catch (HotelException e){
            e.printStackTrace();
        }
    }
}
