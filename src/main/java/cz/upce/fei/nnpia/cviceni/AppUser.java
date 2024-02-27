package cz.upce.fei.nnpia.cviceni;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import jakarta.persistence.*;

import java.util.Date;

/**
 * read, update, delete
 */
@Entity
@Table(name = "app_user")
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    String username;
    String password;
    boolean active;
    Date creation_date;
    Date update_date;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "AppUser{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", active=" + active +
                '}';
    }
}
