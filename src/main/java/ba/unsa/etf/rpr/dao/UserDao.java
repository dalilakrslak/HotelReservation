package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.HotelException;

/**
 * Dao interface for User domain bean
 *
 * @author Dalila Krslak
 */
public interface UserDao extends Dao<User>{
    /**
     * Returns user whose username and password are given as parameters.
     * @param username search String for username of user
     * @param password search String for password of user
     * @return User instance
     */
    public User checkUser(String username, String password);

    /**
     * Returns true if username, given as parameter, exists in database.
     *
     * @param username search String for username
     * @return boolean
     */
    public boolean checkUsername(String username);
    public int getLoggedInId(String username, String password) throws HotelException;
}
