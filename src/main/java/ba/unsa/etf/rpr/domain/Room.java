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

    public Room(){

    }

    public Room(String description, String price) {
        this.description = description;
        this.price = price;
    }

    @Override
    public void setId(int id) {
        this.room_id = id;
    }

    @Override
    public int getId() {
        return room_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return "Room{" +
                "room_id=" + room_id +
                ", description='" + description + '\'' +
                ", price='" + price + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return room_id == room.room_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(room_id, description, price);
    }
}
