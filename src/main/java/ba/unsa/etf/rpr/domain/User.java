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

    public User(String first_name, String last_name, String email, boolean admin, String username, String password) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.admin = admin;
        this.username = username;
        this.password = password;
    }
    public User(){

    }
    @Override
    public void setId(int id) {
        this.user_id = id;
    }

    @Override
    public int getId() {
        return user_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return user_id == user.user_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(user_id, first_name, last_name, email, admin, username, password);
    }

}
