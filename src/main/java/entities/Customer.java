package entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "customers")
@Getter @Setter
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private int customer_id;
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
    @Column(name = "t_number")
    private String t_number;

    public Customer(String login, String password, String fname, String surname, String lname, String t_number) {
        this.login = login;
        this.password = password;
        this.fname = fname;
        this.surname = surname;
        this.lname = lname;
        this.t_number = t_number;
    }
    public Customer(){

    }
}
