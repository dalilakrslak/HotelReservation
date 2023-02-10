package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.HotelException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests for UserManager class
 * @author Dalila Krslak
 */
public class UserManagerTest {
    UserManager userManager = new UserManager();
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
}
