package entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter @Setter
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int order_id;
    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer_id;
    @Column(name = "address")
    private String address;
    @Column(name = "date")
    private LocalDate date;
    @OneToMany(mappedBy = "order_id", cascade = CascadeType.ALL)
    private List<Instance> instanceList;
    public Order(Customer customer_id, String address, LocalDate date) {
        this.customer_id = customer_id;
        this.address = address;
        this.date = date;
    }
    public Order(Customer customer_id, String address, LocalDate date, List<Instance> instanceList) {
        this.customer_id = customer_id;
        this.address = address;
        this.date = date;
        this.instanceList = instanceList;
        for (Instance inst:
             instanceList) {
            inst.setOrder_id(this);
        }
    }
    public Order() {

    }
}
