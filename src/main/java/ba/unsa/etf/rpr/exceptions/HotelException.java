package ba.unsa.etf.rpr.exceptions;

/**
 * HotelException is a custom exception class for handling errors.
 * @author Dalila KRslak
 */
public class HotelException extends Exception{
    public HotelException(String message, Exception reason){
        super(message, reason);
    }
    public HotelException(String message) {
        super(message);
    }
}
