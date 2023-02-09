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
}