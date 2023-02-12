package ba.unsa.etf.rpr.domain;
import java.util.Date;
import java.util.Objects;

/**
 * holds information about reservation
 * @author Dalila Krslak
 */
public class Reservations implements Idable{
    private int reservation_id;
    private Date check_in;
    private Date check_out;
    private Room room_id;
    private User person_id;

    /**
     * no-arg constructor
     */
    public Reservations(){

    }

    /**
     * Parameterized constructor
     * @param check_in Date instance
     * @param check_out Date instance
     * @param room_id Room instance
     * @param person_id User instance
     */
    public Reservations(Date check_in, Date check_out, Room room_id, User person_id) {
        this.check_in = check_in;
        this.check_out = check_out;
        this.room_id = room_id;
        this.person_id = person_id;
    }
    /**
     * sets or updates the value of id
     * @param id int value
     */
    @Override
    public void setId(int id) {
        this.reservation_id = id;
    }
    /**
     * gets the value of id
     * @return int value
     */
    @Override
    public int getId() {
        return reservation_id;
    }
    /**
     * gets the value of check_in
     * @return Date value
     */
    public Date getCheck_in() {
        return check_in;
    }
    /**
     * sets or updates the value of check_in
     * @param check_in Date value
     */
    public void setCheck_in(Date check_in) {
        this.check_in = check_in;
    }
    /**
     * gets the value of check_out
     * @return Date value
     */
    public Date getCheck_out() {
        return check_out;
    }

    /**
     * sets or updates the value of check_out
     * @param check_out Date value
     */
    public void setCheck_out(Date check_out) {
        this.check_out = check_out;
    }
    /**
     * gets the value of room_id
     * @return Room value
     */
    public Room getRoom_id() {
        return room_id;
    }
    /**
     * sets or updates the value of room_id
     * @param room_id Room value
     */
    public void setRoom_id(Room room_id) {
        this.room_id = room_id;
    }
    /**
     * gets the value of person_id
     * @return User value
     */
    public User getPerson_id() {
        return person_id;
    }
    /**
     * sets or updates the value of person_id
     * @param person_id User value
     */
    public void setPerson_id(User person_id) {
        this.person_id = person_id;
    }

    /**
     * returns the String representation of the object.
     * @return String value
     */
    @Override
    public String toString() {
        return "Reservations{" +
                "reservation_id=" + reservation_id +
                ", check_in=" + check_in +
                ", check_out=" + check_out +
                ", room_id=" + room_id +
                ", person_id=" + person_id +
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
        Reservations that = (Reservations) o;
        return reservation_id == that.reservation_id;
    }

    /**
     * generating an integer value by a hashing algorithm.
     * @return integer value
     */
    @Override
    public int hashCode() {
        return Objects.hash(reservation_id, check_in, check_out, room_id, person_id);
    }

}
