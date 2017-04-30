package audioshop.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by vasya on 023 23 01 2017.
 */
@Entity
@Table(name="connection")
public class Connection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String connection;
    @ManyToMany
    @JoinTable(name = "player_connection",
            joinColumns = @JoinColumn(name = "id_connection"),
            inverseJoinColumns = @JoinColumn(name = "id_player"))
    private List<Player> players;

    @OneToMany(mappedBy = "connection")
    private List<Headphone> headphones;

    @OneToMany(mappedBy = "connection")
    private List<Speakers> speakers;

    @OneToMany(mappedBy = "connection")
    private List<Cord> cords;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getConnection() {
        return connection;
    }

    public void setConnection(String connection) {
        this.connection = connection;
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

    public void setSpeakers(List<Speakers> speakerss) {
        this.speakers = speakerss;
    }

    public List<Cord> getCords() {
        return cords;
    }

    public void setCords(List<Cord> cords) {
        this.cords = cords;
    }

    public Connection() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Connection that = (Connection) o;

        return id == that.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
