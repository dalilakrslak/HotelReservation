package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.domain.Room;
import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.HotelException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests for RoomManager class
 * @author Dalila Krslak
 */
public class RoomManagerTest {
    RoomManager roomManager = new RoomManager();
    @Test
    void testAdd(){
        Room room = new Room();
        room.setDescription("ocean view");
        room.setPrice("$100");
        room.setStatus(false);
        room.setKapacitet(15);
        boolean test = false;
        try{
            roomManager.add(room);
            List<Room> list = roomManager.getAll();
            for(Room room1: list){
                if(room1.getDescription().equals("ocean view")){
                    roomManager.delete(room1.getId());
                    test = true;
                    break;
                }
            }
        }
        catch(HotelException e){
            throw new RuntimeException(e);
        }
        assertTrue(test);
    }
}
