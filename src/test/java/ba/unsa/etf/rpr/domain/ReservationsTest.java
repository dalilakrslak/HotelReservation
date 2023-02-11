package ba.unsa.etf.rpr.domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


/**
 * Tests for Reservations class
 * @author Dalila Krslak
 */
public class ReservationsTest {
    @Test
    public void testSettersAndGetters(){
        Reservations reservations = new Reservations();
        java.sql.Date checkIn = java.sql.Date.valueOf(LocalDate.of(2023, Month.APRIL, 12));
        java.sql.Date checkOut = java.sql.Date.valueOf(LocalDate.of(2023, Month.APRIL, 13));
        reservations.setCheck_in(checkIn);
        reservations.setCheck_out(checkOut);
        reservations.setPerson_id(new User());
        reservations.setRoom_id(new Room());
        assertEquals(java.sql.Date.valueOf(LocalDate.of(2023, Month.APRIL, 12)), reservations.getCheck_in());
        assertEquals(java.sql.Date.valueOf(LocalDate.of(2023, Month.APRIL, 13)), reservations.getCheck_out());
        assertNotNull(reservations.getPerson_id());
        assertNotNull(reservations.getRoom_id());
    }
}
