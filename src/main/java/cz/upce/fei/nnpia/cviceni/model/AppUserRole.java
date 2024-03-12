package cz.upce.fei.nnpia.cviceni.model;

import cz.upce.fei.nnpia.cviceni.AppUser;
import jakarta.persistence.*;

@Entity
@Table(name = "app_user_role")
public class AppUserRole {
    @ManyToOne
    @JoinColumn(name = "app_user_id", referencedColumnName = "id")
    private AppUser user;
    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private Role role;
    @Id
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
