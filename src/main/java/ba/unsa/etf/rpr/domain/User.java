package ba.unsa.etf.rpr.domain;
import java.util.Objects;

/**
 * holds information about user
 * @author Dalila Krslak
 */
public class User implements Idable {
    private int user_id;
    private String first_name;
    private String last_name;
    private String email;
    private boolean admin;
    private String username;
    private String password;

    /**
     * Parameterized constructor
     * @param first_name String value
     * @param last_name String value
     * @param email String value
     * @param admin boolean value
     * @param username String value
     * @param password String value
     */
    public User(String first_name, String last_name, String email, boolean admin, String username, String password) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.admin = admin;
        this.username = username;
        this.password = password;
    }
    /**
     * no-arg constructor
     */
    public User(){

    }
    /**
     * sets or updates the value of id
     * @param id int value
     */
    @Override
    public void setId(int id) {
        this.user_id = id;
    }
    /**
     * gets the value of id
     * @return int value
     */
    @Override
    public int getId() {
        return user_id;
    }
    /**
     * gets the value of id
     * @return int value
     */
    public String getFirst_name() {
        return first_name;
    }
    /**
     * sets or updates the value of first_name
     * @param first_name String value
     */
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }
    /**
     * gets the value of id
     * @return int value
     */
    public String getLast_name() {
        return last_name;
    }
    /**
     * sets or updates the value of last_name
     * @param last_name String value
     */
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
    /**
     * gets the value of id
     * @return int value
     */
    public String getEmail() {
        return email;
    }
    /**
     * sets or updates the value of email
     * @param email String value
     */
    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * gets the value of admin
     * @return boolean value
     */
    public boolean isAdmin() {
        return admin;
    }
    /**
     * sets or updates the value of admin
     * @param admin boolean value
     */
    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
    /**
     * gets the value of username
     * @return String value
     */
    public String getUsername() {
        return username;
    }
    /**
     * sets or updates the value of username
     * @param username String value
     */
    public void setUsername(String username) {
        this.username = username;
    }
    /**
     * gets the value of password
     * @return String value
     */
    public String getPassword() {
        return password;
    }
    /**
     * sets or updates the value of password
     * @param password String value
     */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
     * returns the String representation of the object.
     * @return String value
     */
    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", admin=" + admin +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
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
        User user = (User) o;
        return user_id == user.user_id;
    }
    /**
     * generating an integer value by a hashing algorithm.
     * @return integer value
     */
    @Override
    public int hashCode() {
        return Objects.hash(user_id, first_name, last_name, email, admin, username, password);
    }

}
