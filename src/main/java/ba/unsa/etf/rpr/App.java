package ba.unsa.etf.rpr;
import org.apache.commons.cli.*;

public class App {
    private static final Option getRooms = new Option("getR", "get-rooms",false, "Printing all rooms from database");
    private static final Option getUsers = new Option("getU", "get-users",false, "Printing all users from database");
    private static final Option getReservations = new Option("getR", "get-reservations",false, "Printing all reservations from database");
}
