package entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "administrators")
@Getter @Setter
public class Administrator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "administrator_id")
    private int administrator_id;
    @Column(name = "login")
    private String login;
    @Column(name = "password")
    private String password;
    @Column(name = "fname")
    private String fname;
    @Column(name = "surname")
    private String surname;
    @Column(name = "lname")
    private String lname;
}
