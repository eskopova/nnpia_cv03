package cz.upce.fei.nnpia.cviceni;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    String title;
    String description;
    Date creation_date;
    Date update_date;

    @ManyToOne
    @JoinColumn(name = "creator_id", referencedColumnName = "id")
    private AppUser creator;
}
