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

    public Reservations(){

    }

    public Reservations(Date check_in, Date check_out, Room room_id, User person_id) {
        this.check_in = check_in;
        this.check_out = check_out;
        this.room_id = room_id;
        this.person_id = person_id;
    }

    @Override
    public void setId(int id) {
        this.reservation_id = id;
    }

    @Override
    public int getId() {
        return reservation_id;
    }

    public Date getCheck_in() {
        return check_in;
    }

    public void setCheck_in(Date check_in) {
        this.check_in = check_in;
    }

    public Date getCheck_out() {
        return check_out;
    }

    public void setCheck_out(Date check_out) {
        this.check_out = check_out;
    }

    public Room getRoom_id() {
        return room_id;
    }

    public void setRoom_id(Room room_id) {
        this.room_id = room_id;
    }

    public User getPerson_id() {
        return person_id;
    }

    public void setPerson_id(User person_id) {
        this.person_id = person_id;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reservations that = (Reservations) o;
        return reservation_id == that.reservation_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(reservation_id, check_in, check_out, room_id, person_id);
    }

}
