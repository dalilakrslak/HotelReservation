package ba.unsa.etf.rpr.domain;

import ba.unsa.etf.rpr.business.RoomManager;
import ba.unsa.etf.rpr.dao.RoomDao;
import ba.unsa.etf.rpr.exceptions.HotelException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

/**
 * Tests for Room class
 * @author Dalila Krslak
 */
public class RoomTest {
    private RoomManager roomManager;
    @Mock
    private RoomDao roomDao;
    public Room room  =  new Room("one-bed", "$30");

    /**
     * initializes fields annotated with Mockito annotations
     * initializes roomManager
     */
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        roomManager = new RoomManager();
    }

    /**
     * tests method add
     * @throws HotelException in case of an error
     */
    @Test
    public void addTest() throws HotelException {
        roomDao.add(room);
        verify(roomDao).add(room);
    }

    /**
     * tests method update
     * @throws Exception in case of an error
     */
    @Test
    void updateTest() throws Exception {
        room.setDescription("two-bed");
        roomDao.update(room);
        verify(roomDao).update(room);
    }
    /**
     * tests constructor
     */
    @Test
    public void testConstructor(){
        Room room = new Room("one-bed", "$30");
        assertEquals("one-bed", room.getDescription());
        assertEquals("$30", room.getPrice());
    }
    /**
     * tests setters and getters
     */
    @Test
    public void testSettersAndGetters() {
        Room room = new Room();
        room.setDescription("one-bed");
        room.setPrice("$30");

        assertEquals("one-bed", room.getDescription());
        assertEquals("$30", room.getPrice());
    }

    /**
     * tests toString method
     */
    @Test
    public void testToString(){
        Room room = new Room("one-bed", "$30");
        String output = "Room{" +
                "room_id=0" +
                ", description='one-bed" + '\'' +
                ", price='$30" + '\'' +
                '}';
        assertEquals(output, room.toString());
    }
    /**
     * tests equals method
     */
    @Test
    public void testEquals(){
        Room room1 = new Room("one-bed", "$30");
        Room room2 = new Room("one-bed", "$30");
        assertTrue(room1.equals(room2));
    }
}
