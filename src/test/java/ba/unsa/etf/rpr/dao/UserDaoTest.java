package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class UserDaoTest {
    /**
     * tests setters and getters in UserDao
     */
    @Test
    public void testUserSettersAndGetters() {
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
}
