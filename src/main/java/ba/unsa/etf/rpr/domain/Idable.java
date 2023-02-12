package ba.unsa.etf.rpr.domain;

/**
 * Interface that forces all POJO beans to have ID field.
 * @author Dalila Krslak
 */
public interface Idable {
    /**
     * sets or updates the value of id
     * @param id int value
     */
    void setId(int id);

    /**
     * gets the value of id
     * @return int value
     */
    int getId();
}
