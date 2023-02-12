package ba.unsa.etf.rpr.domain;
import java.util.Objects;

/**
 * holds information about available rooms
 * @author Dalila Krslak
 */
public class Room implements Idable{
    private int room_id;
    private String description;
    private String price;
    /**
     * no-arg constructor
     */
    public Room(){

    }

    /**
     * Parameterized constructor
     * @param description String value
     * @param price String value
     */
    public Room(String description, String price) {
        this.description = description;
        this.price = price;
    }
    /**
     * sets or updates the value of id
     * @param id int value
     */
    @Override
    public void setId(int id) {
        this.room_id = id;
    }
    /**
     * gets the value of id
     * @return int value
     */
    @Override
    public int getId() {
        return room_id;
    }

    /**
     * gets the value of description
     * @return String value
     */
    public String getDescription() {
        return description;
    }

    /**
     * sets or updates the value of description
     * @param description String value
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * gets the value of price
     * @return String value
     */
    public String getPrice() {
        return price;
    }

    /**
     * sets or updates the value of price
     * @param price String value
     */
    public void setPrice(String price) {
        this.price = price;
    }

    /**
     * returns the String representation of the object.
     * @return String value
     */
    @Override
    public String toString() {
        return "Room{" +
                "room_id=" + room_id +
                ", description='" + description + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
    /**
     * compares two strings, and returns true if the strings are equal, and false if not
     * @param o Object
     * @return boolean value
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return room_id == room.room_id;
    }
    /**
     * generating an integer value by a hashing algorithm.
     * @return integer value
     */
    @Override
    public int hashCode() {
        return Objects.hash(room_id, description, price);
    }
}
