package ba.unsa.etf.rpr;
import org.apache.commons.cli.*;

public class App {
    private static final Option addRoom = new Option("add","add-room",false, "Adding new room to database");
    private static final Option deleteRoom = new Option("delete","delete-room",false, "Deleting room from database");
    private static final Option updateRoom = new Option("update", "update-room",false, "Updating room from database");

    private static final Option getRooms = new Option("getR", "get-rooms",false, "Printing all rooms from database");
    private static final Option getUsers = new Option("getU", "get-users",false, "Printing all users from database");
    private static final Option getReservations = new Option("getR", "get-reservations",false, "Printing all reservations from database");


}
