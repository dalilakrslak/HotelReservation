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
     * @param username search String for username
     * @return boolean value
     */
    public boolean checkUsername(String username);
    /**
     * Fetches User object from table USER defined by username and password given as parameter
     * @param username String value that represents username
     * @param password String value that represents password
     * @return int value for id
     * @throws HotelException in case of an error
     */
    public int getLoggedInId(String username, String password) throws HotelException;
}
