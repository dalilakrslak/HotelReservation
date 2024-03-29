package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Reservations;
import ba.unsa.etf.rpr.exceptions.HotelException;

import java.sql.ResultSet;
import java.util.Map;
import java.util.TreeMap;

/**
 * MySQL Implementation of DAO
 * @author Dalila Krslak
 */
public class ReservationsDaoSQLImpl extends AbstractDao<Reservations> implements ReservationsDao{
    private static ReservationsDaoSQLImpl instance = null;

    /**
     * Constructor for ReservationsDaoSQLImpl
     */
    public ReservationsDaoSQLImpl() {
        super("RESERVATIONS");
    }
    /**
     * We don't need more than one object for CRUD operations on table 'RESERVATIONS' so we will use Singleton
     * This method will call private constructor in instance==null and then return that instance
     * @author Dalila Krslak
     * @return ReservationsDaoSQLImpl
     */
    public static ReservationsDaoSQLImpl getInstance(){
        if(instance==null)
            instance = new ReservationsDaoSQLImpl();
        return instance;
    }
    /**
     * Removes the singleton instance of the ReservationsDaoSQLImpl class.
     */
    public static void removeInstance(){
        if(instance!=null)
            instance=null;
    }
    /**
     *Maps a row from the result set to a Reservations object
     *@param rs The result set from the database query
     *@return Reservations object with properties set according to the values in the result set
     *@throws HotelException if there is an error when retrieving values from the result set
     */
    @Override
    public Reservations row2object(ResultSet rs) throws HotelException {
        try{
            Reservations reservations = new Reservations();
            reservations.setId(rs.getInt("reservation_id"));
            reservations.setCheck_in(rs.getDate("check_in"));
            reservations.setCheck_out(rs.getDate("check_out"));
            reservations.setRoom_id(DaoFactory.roomDao().getById(rs.getInt("room_id")));
            reservations.setPerson_id(DaoFactory.userDao().getById(rs.getInt("person_id")));
            return reservations;
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
    public Map<String, Object> object2row(Reservations object) {
        Map<String, Object> item = new TreeMap<>();
        item.put("reservation_id", object.getId());
        item.put("check_in", object.getCheck_in());
        item.put("check_out", object.getCheck_out());
        item.put("room_id", object.getRoom_id().getId());
        item.put("person_id", object.getPerson_id().getId());
        return item;
    }
}
