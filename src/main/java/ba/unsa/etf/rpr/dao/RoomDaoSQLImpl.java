package ba.unsa.etf.rpr.dao;


import ba.unsa.etf.rpr.domain.Room;
import ba.unsa.etf.rpr.exceptions.HotelException;

import java.sql.ResultSet;
import java.util.Map;
import java.util.TreeMap;

/**
 * MySQL Implementation of DAO
 * @author Dalila Krslak
 */
public class RoomDaoSQLImpl extends AbstractDao<Room> implements RoomDao{
    private static RoomDaoSQLImpl instance = null;
    public RoomDaoSQLImpl() {
        super("ROOM");
    }
    /**
     * @author Dalila Krslak
     * @return RoomDaoSQLImpl
     * We don't need more than one object for CRUD operations on table 'ROOM' so we will use Singleton
     * This method will call private constructor in instance==null and then return that instance
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

    @Override
    public Room row2object(ResultSet rs) throws HotelException {
        try {
            Room room = new Room();
            room.setId(rs.getInt("room_id"));
            room.setDescription(rs.getString("description"));
            room.setPrice(rs.getString("price"));
            room.setStatus(rs.getBoolean("status"));
            room.setKapacitet(rs.getInt("kapacitet"));
            return  room;
        }
        catch (Exception e){
            throw new HotelException(e.getMessage(), e);
        }
    }

    @Override
    public Map<String, Object> object2row(Room object) {
        Map<String, Object> item = new TreeMap<>();
        item.put("room_id", object.getId());
        item.put("description", object.getDescription());
        item.put("price", object.getPrice());
        item.put("status", object.isStatus());
        item.put("kapacitet", object.getKapacitet());
        return item;
    }

}
