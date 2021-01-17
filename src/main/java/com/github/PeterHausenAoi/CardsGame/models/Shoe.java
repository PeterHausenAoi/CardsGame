package com.github.PeterHausenAoi.CardsGame.models;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "shoes")
public class Shoe extends BaseEntity {
    @OneToOne
    @JoinColumn(name = "game_id", referencedColumnName = "id")
    private Game game;

    @OneToMany(mappedBy = "shoe", fetch = FetchType.LAZY)
    private Set<ShoeDeck> shoeDecks;

    public Shoe() {
    }

    public Shoe(Long id) {
        super(id);
    }

    public Shoe(Game game) {
        this.game = game;
    }

    public Shoe(Long id, Game game) {
        super(id);
        this.game = game;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Set<ShoeDeck> getShoeDecks() {
        return shoeDecks;
    }

    public void setShoeDecks(Set<ShoeDeck> shoeDecks) {
        this.shoeDecks = shoeDecks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Shoe shoe = (Shoe) o;
        return Objects.equals(game, shoe.game) && Objects.equals(shoeDecks, shoe.shoeDecks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), game, shoeDecks);
    }
}
