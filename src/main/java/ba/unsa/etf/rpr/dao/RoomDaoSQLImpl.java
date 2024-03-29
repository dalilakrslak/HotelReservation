package ba.unsa.etf.rpr.dao;


import ba.unsa.etf.rpr.domain.Room;
import ba.unsa.etf.rpr.exceptions.HotelException;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * MySQL Implementation of DAO
 * @author Dalila Krslak
 */
public class RoomDaoSQLImpl extends AbstractDao<Room> implements RoomDao{
    private static RoomDaoSQLImpl instance = null;

    /**
     * constructor for RoomDaoSQLImpl
     */
    public RoomDaoSQLImpl() {
        super("ROOM");
    }
    /**
     * We don't need more than one object for CRUD operations on table 'ROOM' so we will use Singleton
     * This method will call private constructor in instance==null and then return that instance
     * @author Dalila Krslak
     * @return RoomDaoSQLImpl
     */
    public static RoomDaoSQLImpl getInstance(){
        if(instance==null)
            instance = new RoomDaoSQLImpl();
        return instance;
    }
    /**
     * Removes the singleton instance of the RoomDaoSQLImpl class.
     */
    public static void removeInstance(){
        if(instance!=null)
            instance=null;
    }
    /**
     *Maps a row from the result set to a Room object
     *@param rs The result set from the database query
     *@return Room object with properties set according to the values in the result set
     *@throws HotelException if there is an error when retrieving values from the result set
     */
    @Override
    public Room row2object(ResultSet rs) throws HotelException {
        try {
            Room room = new Room();
            room.setId(rs.getInt("room_id"));
            room.setDescription(rs.getString("description"));
            room.setPrice(rs.getString("price"));
            return  room;
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
    public Map<String, Object> object2row(Room object) {
        Map<String, Object> item = new TreeMap<>();
        item.put("room_id", object.getId());
        item.put("description", object.getDescription());
        item.put("price", object.getPrice());
        return item;
    }
    /**
     * Fetches Room object from table ROOM defined by description given as parameter
     * @param description String value that represents description
     * @return Room instance
     * @throws HotelException in case of an error
     */
    @Override
    public Room getByDescription(String description) throws HotelException {
        try {
            List<Room> rooms = executeQuery("SELECT * FROM ROOM WHERE description = ?", new Object[]{description});
            return rooms.get(0);
        } catch (HotelException e) {
            throw new HotelException(e.getMessage(), e);
        }
    }
}
