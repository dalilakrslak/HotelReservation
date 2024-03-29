package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Reservations;
import ba.unsa.etf.rpr.exceptions.HotelException;

import java.util.List;
/**
 * Business Logic Layer for management of Reservations
 * @author Dalila Krslak
 */
public class ReservationsManager {
    /**
     * Adds Reservations object to RESERVATIONS table
     * @param r Reservations
     * @return Reservations instance
     * @throws HotelException in case of an error
     */
    public Reservations add(Reservations r) throws HotelException {
        if (r.getId() != 0){
            throw new HotelException("Can't add Reservations with ID. ID is autogenerated");
        }
        return DaoFactory.reservationsDao().add(r);
    }

    /**
     * Deletes Reservations object from RESERVATIONS table.
     * @param id int
     * @throws HotelException in case of an error
     */
    public void delete(int id) throws HotelException {
        DaoFactory.reservationsDao().delete(id);
    }

    /**
     * Updates Reservations object from RESERVATIONS table.
     * @param r Reservations
     * @throws HotelException in case of an error
     */
    public void update(Reservations r) throws HotelException {
        DaoFactory.reservationsDao().update(r);
    }

    /**
     * Fetches all Reservations objects from table RESERVATIONS and stores it in list
     * @return List of Reservations objects
     * @throws HotelException in case of an error
     */
    public List<Reservations> getAll() throws HotelException{
        return DaoFactory.reservationsDao().getAll();
    }

    /**
     * Fetches Reservations object from table RESERVATIONS defined by id given as parameter
     * @param ReservationsId id
     * @return Reservations instance
     * @throws HotelException in case of an error
     */
    public Reservations getById(int ReservationsId) throws HotelException{
        return DaoFactory.reservationsDao().getById(ReservationsId);
    }
}
