package ba.unsa.etf.rpr.dao;

/**
 * Factory method for singleton implementation of DAOs
 *
 * @author Dalila Krslak
 */
public class DaoFactory {

    private static final UserDao userDao = UserDaoSQLImpl.getInstance();
    private static final RoomDao roomDao = RoomDaoSQLImpl.getInstance();
    private static final ReservationsDao reservationsDao = ReservationsDaoSQLImpl.getInstance();

    /**
     *A private constructor to prevent instantiation of this class.
     */
    private DaoFactory(){
    }
    /**
     * A singleton instance of the UserDao class, which is used to access and manipulate user data in a database.
     * @return UserDao instance
     */
    public static UserDao userDao(){
        return userDao;
    }
    /**
     * A singleton instance of the RoomDao class, which is used to access and manipulate room data in a database.
     * @return RoomDao instance
     */
    public static RoomDao roomDao(){
        return roomDao;
    }
    /**
     * A singleton instance of the ReservationsDao class, which is used to access and manipulate reservations data in a database.
     * @return ReservationsDao instance
     */
    public static ReservationsDao reservationsDao(){
        return reservationsDao;
    }
}
