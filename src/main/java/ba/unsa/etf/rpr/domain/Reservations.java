package ba.unsa.etf.rpr.domain;
import java.util.Date;
import java.util.Objects;

/**
 * holds information about reservation
 * @author Dalila Krslak
 */
public class Reservations {
    private int reservation_id;
    private Date check_in;
    private Date check_out;
    private int number_of_people;
    private int room_id;
    private int person_id;

    public int getReservation_id() {
        return reservation_id;
    }

    public void setReservation_id(int reservation_id) {
        this.reservation_id = reservation_id;
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

    public int getNumber_of_people() {
        return number_of_people;
    }

    public void setNumber_of_people(int number_of_people) {
        this.number_of_people = number_of_people;
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public int getPerson_id() {
        return person_id;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }

    @Override
    public String toString() {
        return "Reservations{" +
                "reservation_id=" + reservation_id +
                ", check_in=" + check_in +
                ", check_out=" + check_out +
                ", number_of_people=" + number_of_people +
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
        return Objects.hash(reservation_id, check_in, check_out, number_of_people, room_id, person_id);
    }
}
