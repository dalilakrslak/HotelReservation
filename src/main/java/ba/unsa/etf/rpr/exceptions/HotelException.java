package ba.unsa.etf.rpr.exceptions;

/**
 * HotelException is a custom exception class for handling errors.
 * @author Dalila KRslak
 */
public class HotelException extends Exception{
    /**
     * Two-parameter constructor
     * @param message String
     * @param reason Exception
     */
    public HotelException(String message, Exception reason){
        super(message, reason);
    }

    /**
     * One-parameter constructor
     * @param message String
     */
    public HotelException(String message) {
        super(message);
    }
}
