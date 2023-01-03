package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Reservations;
import ba.unsa.etf.rpr.exceptions.HotelException;

import java.util.List;

public class ReservationsManager {
    public Reservations add(Reservations r) throws HotelException {
        if (r.getId() != 0){
            throw new HotelException("Can't add Reservations with ID. ID is autogenerated");
        }
        return DaoFactory.reservationsDao().add(r);
    }

    public void delete(int id) throws HotelException {
        DaoFactory.reservationsDao().delete(id);
    }

    public void update(Reservations r) throws HotelException {
        DaoFactory.reservationsDao().update(r);
    }

    public List<Reservations> getAll() throws HotelException{
        return DaoFactory.reservationsDao().getAll();
    }

    public Reservations getById(int ReservationsId) throws HotelException{
        return DaoFactory.reservationsDao().getById(ReservationsId);
    }
}