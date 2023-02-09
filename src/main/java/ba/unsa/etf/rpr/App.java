package ba.unsa.etf.rpr;
import org.apache.commons.cli.*;

import java.io.PrintWriter;

public class App {
    private static final Option addRoom = new Option("add","add-room",false, "Adding new room to database");
    private static final Option deleteRoom = new Option("delete","delete-room",false, "Deleting room from database");
    private static final Option updateRoom = new Option("update", "update-room",false, "Updating room from database");

    private static final Option getRooms = new Option("getR", "get-rooms",false, "Printing all rooms from database");
    private static final Option getUsers = new Option("getU", "get-users",false, "Printing all users from database");
    private static final Option getReservations = new Option("getR", "get-reservations",false, "Printing all reservations from database");

    public static void printFormattedOptions(Options options) {
        HelpFormatter helpFormatter = new HelpFormatter();
        PrintWriter printWriter = new PrintWriter(System.out);
        helpFormatter.printUsage(printWriter, 150, "java -jar projekat1.jar [option] 'something else if needed' ");
        helpFormatter.printOptions(printWriter, 150, options, 2, 7);
        printWriter.close();
    }

    public static Options addOptions() {
        Options options = new Options();
        options.addOption(addRoom);
        options.addOption(deleteRoom);
        options.addOption(updateRoom);
        options.addOption(getRooms);
        options.addOption(getReservations);
        options.addOption(getUsers);
        return options;
    }
    public static void main(String[] args) throws Exception{

    }
}
