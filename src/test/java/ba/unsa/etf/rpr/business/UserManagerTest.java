package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.HotelException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for UserManager class
 * @author Dalila Krslak
 */
public class UserManagerTest {
    UserManager userManager = new UserManager();

    /**
     * Testing add method
     */
    @Test
    void testAdd(){
        User user = new User();
        user.setFirst_name("Zerina");
        user.setLast_name("Tanovic");
        user.setUsername("ztanovic1");
        user.setEmail("ztanovic1@etf.unsa.ba");
        user.setPassword("iusius");
        user.setAdmin(false);
        boolean test = false;
        try{
            userManager.add(user);
            List<User> list = userManager.getAll();
            for(User user1: list){
                if(user1.getUsername().equals("ztanovic1")){
                    userManager.delete(user1.getId());
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

    /**
     * Testing getAll method
     */
    @Test
    void testGetAll(){
        assertDoesNotThrow(() -> {
            userManager.getAll();
        });
    }

    /**
     * Testing delete method
     */
    @Test
    void testDelete(){
        User user = new User();
        user.setFirst_name("Zerina");
        user.setLast_name("Tanovic");
        user.setUsername("ztanovic1");
        user.setEmail("ztanovic1@etf.unsa.ba");
        user.setPassword("iusius");
        user.setAdmin(false);
        boolean test = true;
        try{
            userManager.add(user);
            List<User> list = userManager.getAll();
            for(User user1: list){
                if(user1.getUsername().equals("ztanovic1")){
                    userManager.delete(user1.getId());
                    break;
                }
            }
            list = userManager.getAll();
            for (User user1: list){
                if(user1.getUsername().equals("ztanovic1")){
                    test = false;
                    break;
                }
            }
        }
        catch(HotelException e){
            throw new RuntimeException(e);
        }
        assertTrue(test);
    }
    /**
     * Testing validateUsername method
     */
    @Test
    void testValidateUsername(){
        User user = new User();
        user.setUsername("daki");
        HotelException thrown = assertThrows(HotelException.class, () -> userManager.validateUsername(user.getUsername()));
        assertEquals("Username must be between 5 and 15 chars", thrown.getMessage());
    }

    /**
     * Testing searchById method
     */
    @Test
    void testSearchById(){
        try {
            assertEquals("Dalila",userManager.getById(1).getFirst_name());
        } catch (HotelException e) {
            throw new RuntimeException(e);
        }
    }
}
