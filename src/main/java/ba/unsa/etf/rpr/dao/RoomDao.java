package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Room;
import ba.unsa.etf.rpr.exceptions.HotelException;

/**
 * Dao interface for Room domain bean
 *
 * @author Dalila Krslak
 */
public interface RoomDao extends Dao<Room>{
    Room getByDescription(String description) throws HotelException;
}
