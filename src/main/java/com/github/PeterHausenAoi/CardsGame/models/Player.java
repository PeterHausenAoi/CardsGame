package com.github.PeterHausenAoi.CardsGame.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "players")
public class Player extends BaseEntity{
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "game_id", nullable = false)
    private Game game;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Player player = (Player) o;
        return Objects.equals(game, player.game);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), game);
    }
}
