package ba.unsa.etf.rpr.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for Room class
 * @author Dalila Krslak
 */
public class RoomTest {
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
