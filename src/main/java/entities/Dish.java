package entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "dishes")
@Getter @Setter
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dish_id")
    private int dish_id;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private int price;
    @Column(name = "description")
    private String description;
    @Column(name = "image_url")
    private String image_url;

    public Dish(){

    }
    public Dish(String name, int price, String description, String image_url) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.image_url = image_url;
    }
}
