package cz.upce.fei.nnpia.cviceni;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

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
    @NotNull(message = "Username cannot be null")
    @NotBlank(message = "Username cannot be empty")
    @Size(max = 50, message = "Username must be at most 50 characters long")
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
    public void setUsername(String username) { this.username = username; }
    public String getUsername() { return username; }
    public void setPassword(String password) { this.password = password; }
    public void setActive(boolean active) { this.active = active; }
    public boolean isActive() { return active; }
    public void setCreationDate(Date date) { this.creation_date = date;}
    public void setUpdateDate(Date date) { this.update_date = date;}

    @Override
    public String toString() {
        return "AppUser{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", active=" + active +
                '}';
    }
}
