package audioshop.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by vasya on 015 15 03 2017.
 */
@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String category;


    @OneToMany(mappedBy = "category")
    private List<Player> players;

    @OneToMany(mappedBy = "category")
    private List<Cord> cords;

    @OneToMany(mappedBy = "category")
    private List<Headphone> headphones;

    @OneToMany(mappedBy = "category")
    private List<Speakers> speakers;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Cord> getCords() {
        return cords;
    }

    public void setCords(List<Cord> cords) {
        this.cords = cords;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;

        return id == category.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
