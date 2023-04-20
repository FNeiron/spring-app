package entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "instances")
@Getter @Setter
public class Instance implements Serializable {
    public Instance(Dish dish_id, int amount) {
        this.dish_id = dish_id;
        this.amount = amount;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "article")
    private int article;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order_id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dish_id")
    private Dish dish_id;
    @Column(name = "amount")
    private int amount;

    public Instance() {

    }
}
