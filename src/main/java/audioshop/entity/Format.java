package audioshop.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by vasya on 022 22 01 2017.
 */
@Entity
@Table(name="format")
public class Format {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String format;

    @ManyToMany
    @JoinTable(name = "player_format",
            joinColumns = @JoinColumn(name = "id_format"),
            inverseJoinColumns = @JoinColumn(name = "id_player"))
    private List<Player> players;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Format() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Format format = (Format) o;

        return id == format.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
