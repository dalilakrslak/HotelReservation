package ba.unsa.etf.rpr.exceptions;

public class HotelException extends Exception{
    public HotelException(String message, Exception reason){
        super(message, reason);
    }
    public HotelException(String message) {
        super(message);
    }
}
