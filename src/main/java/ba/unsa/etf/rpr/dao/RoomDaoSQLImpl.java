package ba.unsa.etf.rpr.dao;


import ba.unsa.etf.rpr.domain.Room;
import ba.unsa.etf.rpr.exceptions.HotelException;

import java.sql.ResultSet;
import java.util.Map;
import java.util.TreeMap;

public class RoomDaoSQLImpl extends AbstractDao<Room> implements RoomDao{

    public RoomDaoSQLImpl() {
        super("ROOM");
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
