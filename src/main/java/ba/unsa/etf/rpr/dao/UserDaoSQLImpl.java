package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.HotelException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * MySQL Implementation of DAO
 * @author Dalila Krslak
 */
public class UserDaoSQLImpl extends AbstractDao<User> implements UserDao{
    private static UserDaoSQLImpl instance = null;

    /**
     * Constructor for UserDaoSQLImpl
     */
    public UserDaoSQLImpl(){
        super("USER");
    }
    /**
     * @author Dalila Krslak
     * @return UserDaoSQLImpl
     * We don't need more than one object for CRUD operations on table 'USER' so we will use Singleton
     * This method will call private constructor in instance==null and then return that instance
     */
    public static UserDaoSQLImpl getInstance(){
        if(instance==null)
            instance = new UserDaoSQLImpl();
        return instance;
    }
    /**
     * Removes the singleton instance of the UserDaoSQLImpl class.
     */
    public static void removeInstance(){
        if(instance!=null)
            instance=null;
    }
    /**
     *Maps a row from the result set to a User object
     *@param rs The result set from the database query
     *@return User object with properties set according to the values in the result set
     *@throws HotelException if there is an error when retrieving values from the result set
     */
    @Override
    public User row2object(ResultSet rs) throws HotelException {
        try{
            User user = new User();
            user.setId(rs.getInt("user_id"));
            user.setFirst_name(rs.getString("first_name"));
            user.setLast_name(rs.getString("last_name"));
            user.setEmail(rs.getString("email"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setAdmin(rs.getBoolean("admin"));
            return user;
        }
        catch (Exception e){
            throw new HotelException(e.getMessage(), e);
        }
    }
    /**
     * @param object - object to be mapped
     * @return map representation of object
     */
    @Override
    public Map<String, Object> object2row(User object) {
        Map<String, Object> item = new TreeMap<>();
        item.put("user_id", object.getId());
        item.put("first_name", object.getFirst_name());
        item.put("last_name", object.getLast_name());
        item.put("email", object.getEmail());
        item.put("username", object.getUsername());
        item.put("password", object.getPassword());
        item.put("admin", object.isAdmin());
        return item;
    }
    /**
     * Returns user whose username and password are given as parameters.
     * @param username search String for username of user
     * @param password search String for password of user
     * @return User instance
     */
    public User checkUser(String username, String password) {
        String sql = "SELECT * FROM USER WHERE username = ? AND password = ?";
        User user = null;
        try {
            List<User> u = DaoFactory.userDao().getAll();
            PreparedStatement s=getConnection().prepareStatement(sql);
            s.setString(1, username);
            s.setString(2, password);
            ResultSet r = s.executeQuery();

            if(!r.next()) return null;

            user = row2object(r);
            return user;


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (HotelException e) {
            throw new RuntimeException(e);
        }
        return user;
    }
    /**
     * Returns true if username, given as parameter, exists in database.
     *
     * @param username search String for username
     * @return boolean
     */
    public boolean checkUsername(String username) {
        String sql = "SELECT * FROM USER WHERE username = ?";
        try {
            PreparedStatement s=getConnection().prepareStatement(sql);
            s.setString(1, username);
            ResultSet r = s.executeQuery();
            while(r.next()){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    /**
     * Fetches User object from table USER defined by username and password given as parameter
     * @param username String value that represents username
     * @param password String value that represents password
     * @return int value for id
     * @throws HotelException in case of an error
     */
    public int getLoggedInId(String username, String password) throws HotelException {
        try {
            List<User> l = executeQuery("SELECT * FROM USER WHERE username = ? AND password = ?", new Object[]{username, password});
            if (l.isEmpty()) return 0;
            return l.get(0).getId();
        } catch (HotelException e) {
            throw new HotelException(e.getMessage(), e);
        }
    }
}