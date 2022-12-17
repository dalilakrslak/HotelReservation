package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Reservations;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.util.Properties;

public class ReservationsDaoSQLImpl implements ReservationsDao{
    private Connection connection;

    public ReservationsDaoSQLImpl() {
        try{
            FileReader reader = new FileReader("src/main/resources/db.properties");
            Properties p = new Properties();
            p.load(reader);
            String s1=p.getProperty("url");
            String s2=p.getProperty("user");
            String s3=p.getProperty("password");
            this.connection = DriverManager.getConnection(s1,s2,s3);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public Reservations getById(int reservation_id) {
        PreparedStatement stmt = null;
        try {
            stmt = this.connection.prepareStatement("SELECT * FROM RESERVATIONS WHERE reservation_id= ?");
            stmt.setInt(1, reservation_id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()){
                Reservations reservations = new Reservations();
                reservations.setReservation_id(rs.getInt("reservation_id"));
                reservations.setCheck_in(rs.getDate("check_in"));
                reservations.setCheck_out(rs.getDate("check_out"));
                reservations.setNumber_of_people(rs.getInt("number_of_people"));
                reservations.setRoom_id(new RoomDaoSQLImpl().getById(rs.getInt("room_id")));
                reservations.setPerson_id(new UserDaoSQLImpl().getById(rs.getInt("person_id")));
                rs.close();
                return reservations;
            }else{
                return null;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    private int getMaxId(){
        int id=1;
        try {
            PreparedStatement statement = this.connection.prepareStatement("SELECT MAX(id)+1 FROM reservations");
            ResultSet rs = statement.executeQuery();
            if(rs.next()) {
                id = rs.getInt(1);
                rs.close();
                return id;
            }
        } catch (SQLException e) {
            System.out.println("Problem pri radu sa bazom podataka");
            System.out.println(e.getMessage());
        }
        return id;
    }

    @Override
    public Reservations add(Reservations item) {
        int reservation_id = getMaxId();
        try {
            PreparedStatement stmt = this.connection.prepareStatement("INSERT INTO RESERVATIONS VALUES (reservation_id, item.getCheck_in(), item.getCheck_Out(), item.getNumber_of_people(), item.getRoom_id().getRoom_id(), item.getPerson_id().getUser_id()");
            stmt.executeUpdate();
            item.setReservation_id(reservation_id);
            return item;
        } catch (SQLException e) {
            System.out.println("Problem pri radu sa bazom podataka");
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Reservations update(Reservations item) {
        try{
            PreparedStatement stmt = this.connection.prepareStatement("UPDATE RESERVATIONS SET check_in=?, check_out=?, number_of_people=?, room_id=?, person_id=? WHERE reservation_id=?");
            stmt.setDate(1, (Date) item.getCheck_in());
            stmt.setDate(2, (Date) item.getCheck_out());
            stmt.setInt(3, item.getNumber_of_people());
            stmt.setInt(4, item.getRoom_id().getRoom_id());
            stmt.setInt(5, item.getPerson_id().getUser_id());
            stmt.executeUpdate();
            return item;
        }
        catch (SQLException e){
            System.out.println("Problem pri radu sa bazom podataka");
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void delete(int reservation_id) {
        try{
            PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM RESERVATIONS WHERE reservation_id=?");
            stmt.setInt(1, reservation_id);
            stmt.executeUpdate();
        }catch (SQLException e){
            System.out.println("Problem pri radu sa bazom podataka");
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Reservations> getAll() {
        List<Reservations> reservations = new ArrayList<>();
        try{
            PreparedStatement stmt =  this.connection.prepareStatement("SELECT * FROM RESERVATIONS");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                Reservations reservations1 = new Reservations();
                reservations1.setReservation_id(rs.getInt("reservation_id"));

            }
        }
        catch (SQLException e){
            System.out.println("Problem pri radu sa bazom podataka");
            System.out.println(e.getMessage());
        }
        return reservations;
    }
}
