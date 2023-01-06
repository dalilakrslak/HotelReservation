package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Reservations;
import ba.unsa.etf.rpr.exceptions.HotelException;

import java.sql.ResultSet;
import java.util.Map;
import java.util.TreeMap;


public class ReservationsDaoSQLImpl extends AbstractDao<Reservations> implements ReservationsDao{

    public ReservationsDaoSQLImpl() {
        super("RESERVATIONS");
    }

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
