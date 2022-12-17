package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Room;
import ba.unsa.etf.rpr.domain.User;

import java.io.FileReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class RoomDaoSQLImpl implements RoomDao{
    private Connection connection;

    public RoomDaoSQLImpl(){
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
    public Room getById(int id) {
        String query = "SELECT * FROM ROOM WHERE room_id = ?";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) { // result set is iterator.
                Room room = new Room();
                room.setRoom_id(rs.getInt("room_id"));
                room.setDescription(rs.getString("description"));
                room.setNumber_of_people(rs.getInt("number_of_people"));
                room.setPrice(rs.getString("price"));
                room.setStatus(rs.getBoolean("status"));
                rs.close();
                return room;
            } else {
                return null; // if there is no elements in the result set return null
            }
        } catch (SQLException e) {
            e.printStackTrace(); // poor error handling
        }
        return null;
    }

    @Override
    public Room add(Room item) {
        String insert = "INSERT INTO ROOM(description, number_of_people, price, status) VALUES(?, ?, ?, ?)";
        try{
            PreparedStatement stmt = this.connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, item.getDescription());
            stmt.setInt(2, item.getNumber_of_people());
            stmt.setString(3, item.getPrice());
            stmt.setBoolean(4, item.isStatus());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            rs.next(); // we know that there is one key
            item.setRoom_id(rs.getInt(1)); //set id to return it back
            return item;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Room update(Room item) {
        String insert = "UPDATE ROOM SET description = ?, number_of_people = ?, price = ?, status = ?";
        try{
            PreparedStatement stmt = this.connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            stmt.setObject(1, item.getDescription());
            stmt.setObject(2, item.getNumber_of_people());
            stmt.setObject(3, item.getPrice());
            stmt.setObject(4, item.isStatus());
            stmt.executeUpdate();
            return item;
        }
        catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void delete(int id) {
        String insert = "DELETE FROM ROOM WHERE room_id = ?";
        try{
            PreparedStatement stmt = this.connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            stmt.setObject(1, id);
            stmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Room> getAll() {
        String query = "SELECT * FROM ROOM";
        List<Room> rooms = new ArrayList<>();
        try {
            PreparedStatement stmt = this.connection.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) { // result set is iterator.
                Room room = new Room();
                room.setRoom_id(rs.getInt("room_id"));
                room.setDescription(rs.getString("description"));
                room.setNumber_of_people(rs.getInt("number_of_people"));
                room.setPrice(rs.getString("price"));
                room.setStatus(rs.getBoolean("status"));
                rooms.add(room);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace(); // poor error handling
        }
        return rooms;
    }
}
