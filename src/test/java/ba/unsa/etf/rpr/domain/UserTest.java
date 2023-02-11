package ba.unsa.etf.rpr.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for User class
 * @author Dalila Krslak
 */
public class UserTest {
    /**
     * tests setters and getters in User
     */
    @Test
    public void testSettersAndGetters() {
        User user = new User();
        user.setFirst_name("Niko");
        user.setLast_name("Nikic");
        user.setEmail("nnikic1@etf.unsa.ba");
        user.setUsername("nnikic1");
        user.setPassword("topic");
        user.setAdmin(false);

        assertEquals("Niko", user.getFirst_name());
        assertEquals("Nikic", user.getLast_name());
        assertEquals("nnikic1@etf.unsa.ba", user.getEmail());
        assertEquals("nnikic1", user.getUsername());
        assertEquals("topic", user.getPassword());
        assertFalse(user.isAdmin());
    }

    /**
     * tests constructor
     */
    @Test
    public void testConstructor(){
        User user = new User("Niko", "Nikic", "nnikic1@etf.unsa.ba", false, "nnikic1", "topic");
        assertEquals("Niko", user.getFirst_name());
        assertEquals("Nikic", user.getLast_name());
        assertEquals("nnikic1@etf.unsa.ba", user.getEmail());
        assertEquals("nnikic1", user.getUsername());
        assertEquals("topic", user.getPassword());
        assertFalse(user.isAdmin());
    }

    /**
     * tests toString method
     */
    @Test
    public void testToString(){
        User user = new User("Niko", "Nikic", "nnikic1@etf.unsa.ba", false, "nnikic1", "topic");
        String output = "User{user_id=0" +
                ", first_name='Niko" + '\'' +
                ", last_name='Nikic" + '\'' +
                ", email='nnikic1@etf.unsa.ba" + '\'' +
                ", admin=false" +
                ", username='nnikic1" + '\'' +
                ", password='topic" + '\'' +
                '}';
        assertEquals(output, user.toString());
    }

    /**
     * tests Equals method
     */
    @Test
    public void testEquals(){
        User user1 = new User("Niko", "Nikic", "nnikic1@etf.unsa.ba", false, "nnikic1", "topic");
        User user2 = new User("Niko", "Nikic", "nnikic1@etf.unsa.ba", false, "nnikic1", "topic");
        assertTrue(user1.equals(user2));
    }
}
