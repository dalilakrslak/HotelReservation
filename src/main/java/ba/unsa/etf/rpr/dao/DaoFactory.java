package ba.unsa.etf.rpr.dao;

import java.sql.Connection;

public class DaoFactory {

    private static final UserDao userDao = new UserDaoSQLImpl();
    private static final RoomDao roomDao = new RoomDaoSQLImpl();
    private static final ReservationsDao reservationsDao = new ReservationsDaoSQLImpl();

    private DaoFactory(){
    }

    public static UserDao userDao(){
        return userDao;
    }

    public static RoomDao roomDao(){
        return roomDao;
    }

    public static ReservationsDao reservationsDao(){
        return reservationsDao;
    }
}
