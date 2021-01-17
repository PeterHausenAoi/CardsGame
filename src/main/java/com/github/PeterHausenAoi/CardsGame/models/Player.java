package com.github.PeterHausenAoi.CardsGame.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "players")
@JsonIgnoreProperties({ "game", "shoeCards"})
public class Player extends BaseEntity{
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "game_id", nullable = false)
    private Game game;

    @OneToMany(mappedBy = "player", fetch = FetchType.LAZY)
    private Set<ShoeCard> shoeCards;

    public Player() {
    }

    public Player(Long id) {
        super(id);
    }

    public Player(Game game) {
        this.game = game;
    }

    public Player(Long id, Game game) {
        super(id);
        this.game = game;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Set<ShoeCard> getShoeCards() {
        return shoeCards;
    }

    public void setShoeCards(Set<ShoeCard> shoeCards) {
        this.shoeCards = shoeCards;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return !super.equals(o);
    }
}
