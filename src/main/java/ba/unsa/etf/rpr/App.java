package ba.unsa.etf.rpr;
import ba.unsa.etf.rpr.business.ReservationsManager;
import ba.unsa.etf.rpr.business.RoomManager;
import ba.unsa.etf.rpr.business.UserManager;
import ba.unsa.etf.rpr.domain.Room;
import org.apache.commons.cli.*;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class App {
    private static final Option addRoom = new Option("add","add-room",false, "Adding new room to database");
    private static final Option deleteRoom = new Option("delete","delete-room",false, "Deleting room from database");
    private static final Option updateRoom = new Option("update", "update-room",false, "Updating room from database");

    private static final Option getRooms = new Option("getR", "get-rooms",false, "Printing all rooms from database");
    private static final Option getUsers = new Option("getU", "get-users",false, "Printing all users from database");
    private static final Option getReservations = new Option("getRes", "get-reservations",false, "Printing all reservations from database");

    public static void printFormattedOptions(Options options) {
        HelpFormatter helpFormatter = new HelpFormatter();
        PrintWriter printWriter = new PrintWriter(System.out);
        helpFormatter.printUsage(printWriter, 150, "java -jar HotelReservation.jar [option] 'something else if needed' ");
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
        Options options = addOptions();
        CommandLineParser commandLineParser = new DefaultParser();
        CommandLine cl = commandLineParser.parse(options, args);
        if((cl.hasOption(addRoom.getOpt()))) {
            try {
                RoomManager roomManager = new RoomManager();
                System.out.println("Input in");
                Room room = new Room();
                room.setDescription(cl.getArgList().get(0));
                room.setPrice(cl.getArgList().get(1));
                room.setStatus(Boolean.parseBoolean(cl.getArgList().get(2)));
                room.setKapacitet(Integer.parseInt(cl.getArgList().get(3)));
                roomManager.add(room);
                System.out.println("You successfully added room to database!");
            }
            catch(Exception e){
                System.out.println("Incorrect");
            }
        }
        else if(cl.hasOption(updateRoom.getOpt())){
            try {
                RoomManager roomManager = new RoomManager();
                System.out.println("Input in");
                List<Room> list = roomManager.getAll();
                List<Integer> ids = new ArrayList<>();
                for(int i = 0; i < list.size(); i++){
                    Room room= list.get(i);
                    ids.add(room.getId());
                }
                if(ids.contains(Integer.valueOf(cl.getArgList().get(0)))) {
                    Room room = new Room();
                    room.setId(Integer.parseInt(cl.getArgList().get(0)));
                    room.setDescription(cl.getArgList().get(1));
                    room.setPrice(cl.getArgList().get(2));
                    room.setStatus(Boolean.parseBoolean(cl.getArgList().get(3)));
                    room.setKapacitet(Integer.parseInt(cl.getArgList().get(4)));
                    roomManager.update(room);
                    System.out.println("You successfully updated room in database!");
                }
                else{
                    System.out.println("The given id doesn't exist in the database!");
                }
            }
            catch(Exception e){
                System.out.println("Incorrect");
            }
        }
        else if(cl.hasOption(deleteRoom.getOpt())) {
            try {
                RoomManager roomManager = new RoomManager();
                System.out.println("Input in");
                List<Room> list = roomManager.getAll();
                List<Integer> ids = new ArrayList<>();
                for (int i = 0; i < list.size(); i++) {
                    Room room = list.get(i);
                    ids.add(room.getId());
                }
                if(ids.contains(Integer.valueOf(cl.getArgList().get(0)))) {
                    roomManager.delete(Integer.parseInt(cl.getArgList().get(0)));
                    System.out.println("You successfully deleted room from database!");
                } else {
                    System.out.println("The given id doesn't exist in the database!");
                }
            } catch (Exception e) {
                System.out.println("Incorrect");
            }
        }
        else if(cl.hasOption(getRooms.getOpt())){
            RoomManager movieManager = new RoomManager();
            movieManager.getAll().forEach(c -> System.out.println(c.getDescription()+ " ; " +c.getPrice()
                    +" ; " +c.isStatus()+ " ; " +c.getKapacitet()));
        }
        else if(cl.hasOption(getUsers.getLongOpt())){
            UserManager userManager = new UserManager();
            userManager.getAll().forEach(c -> System.out.println(c.getId() + " ; " + c.getFirst_name() + " ; " + c.getLast_name() + " ; " + c.getEmail() + " ; " + c.getUsername() + " ; " + c.getPassword() + " ; " + c.isAdmin()));
        }
        else if(cl.hasOption(getReservations.getOpt())){
            ReservationsManager reservationsManager = new ReservationsManager();
            reservationsManager.getAll().forEach(c -> System.out.println(c.getId() + " ; " + c.getCheck_in() + " ; " + c.getCheck_out() + " ; " + c.getRoom_id().getDescription() + " ; " + c.getPerson_id().getUsername()));
        }
        else{
            printFormattedOptions(options);
            System.exit(-1);
        }
    }
}
