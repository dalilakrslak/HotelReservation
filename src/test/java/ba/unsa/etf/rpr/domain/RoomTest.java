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
    public Room room  =  new Room("one-bed", "$30", true, 10);
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        roomManager = new RoomManager();
    }
    @Test
    public void addTest() throws HotelException {
        roomDao.add(room);
        verify(roomDao).add(room);
    }

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
        Room room = new Room("one-bed", "$30", true, 10);
        assertEquals("one-bed", room.getDescription());
        assertEquals("$30", room.getPrice());
        assertTrue(room.isStatus());
        assertEquals(10, room.getKapacitet());
    }
    /**
     * tests setters and getters
     */
    @Test
    public void testSettersAndGetters() {
        Room room = new Room();
        room.setDescription("one-bed");
        room.setPrice("$30");
        room.setStatus(true);
        room.setKapacitet(10);

        assertEquals("one-bed", room.getDescription());
        assertEquals("$30", room.getPrice());
        assertTrue(room.isStatus());
        assertEquals(10, room.getKapacitet());
    }
}
