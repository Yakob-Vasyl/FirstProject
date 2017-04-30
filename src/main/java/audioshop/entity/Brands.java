package audioshop.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by vasya on 023 23 01 2017.
 */
@Entity
@Table(name="brands")
public class Brands {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String brand;
    @OneToMany(mappedBy = "brand")
    private List<audioshop.entity.Player> players;

    @OneToMany(mappedBy = "brand")
    private List<audioshop.entity.Headphone> headphones;

    @OneToMany(mappedBy = "brand")
    private List<audioshop.entity.Speakers> speakers;

    @OneToMany(mappedBy = "brand")
    private List<Cord> cords;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Headphone> getHeadphones() {
        return headphones;
    }

    public void setHeadphones(List<Headphone> headphones) {
        this.headphones = headphones;
    }

    public List<Speakers> getSpeakers() {
        return speakers;
    }

    public void setSpeakers(List<Speakers> speakers) {
        this.speakers = speakers;
    }

    public List<Cord> getCords() {
        return cords;
    }

    public void setCords(List<Cord> cords) {
        this.cords = cords;
    }
    public int getId() {
        return id;
    }

    public Brands() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Brands brands = (Brands) o;

        return id == brands.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
