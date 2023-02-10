package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.HotelException;

import java.util.List;
/**
 * Business Logic Layer for management of User
 * @author Dalila Krslak
 */
public class UserManager {
    /**
     * Checks if username is between 5 and 15 characters
     * @param name String
     * @throws HotelException in case of error
     */
    public void validateUsername(String name) throws HotelException{
        if (name == null || name.length() > 15 || name.length() < 5){
            throw new HotelException("Username must be between 5 and 15 chars");
        }
    }

    /**
     * Adds User object to USER table
     * @param u User
     * @return User instance
     * @throws HotelException in case of error
     */
    public User add(User u) throws HotelException {
        if (u.getId() != 0){
            throw new HotelException("Can't add User with ID. ID is autogenerated");
        }
        validateUsername(u.getUsername());

        try{
            return DaoFactory.userDao().add(u);
        }catch (HotelException e){
            if (e.getMessage().contains("UQ_NAME")){
                throw new HotelException("User with same username exists");
            }
            throw e;
        }
    }

    /**
     * Deletes User object from USER table.
     * @param UserId id
     * @throws HotelException in case of an error
     */
    public void delete(int UserId) throws HotelException{
        try{
            DaoFactory.userDao().delete(UserId);
        }catch (HotelException e){
            if (e.getMessage().contains("FOREIGN KEY")){
                throw new HotelException("Cannot delete User which is related to reservations. First delete related reservations before deleting User.");
            }
            throw e;
        }

    }

    /**
     * Updates User object from USER table.
     * @param u User
     * @return User instance
     * @throws HotelException in case of an error
     */
    public User update(User u) throws HotelException {
        validateUsername(u.getUsername());
        return DaoFactory.userDao().update(u);
    }

    /**
     * Fetches all User objects from table USER and stores it in list
     * @return List of User objects
     * @throws HotelException in case of an error
     */
    public List<User> getAll() throws HotelException{
        return DaoFactory.userDao().getAll();
    }

    /**
     * Fetches User object from table USER defined by id given as parameter
     * @param userId id
     * @return User instance
     * @throws HotelException in case of an error
     */
    public User getById(int userId) throws HotelException{
        return DaoFactory.userDao().getById(userId);
    }

}
