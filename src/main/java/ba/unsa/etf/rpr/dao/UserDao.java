package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.User;

/**
 * Dao interface for User domain bean
 *
 * @author Dalila Krslak
 */
public interface UserDao extends Dao<User>{
    public User checkUser(String username, String password);
    public boolean checkUsername(String username);
}
