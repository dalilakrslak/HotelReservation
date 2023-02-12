package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Room;
import ba.unsa.etf.rpr.exceptions.HotelException;

/**
 * Dao interface for Room domain bean
 *
 * @author Dalila Krslak
 */
public interface RoomDao extends Dao<Room>{
    /**
     * Fetches Room object from table ROOM defined by description given as parameter
     * @param description String value that represents description
     * @return Room instance
     * @throws HotelException in case of an error
     */
    public Room getByDescription(String description) throws HotelException;
}
