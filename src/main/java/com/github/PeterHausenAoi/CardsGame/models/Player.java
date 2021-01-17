package com.github.PeterHausenAoi.CardsGame.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "players")
public class Player extends BaseEntity{
    @Column(name = "game_id")
    private Long gameID;

    public Player() {
    }

    public Player(Long gameID) {
        this.gameID = gameID;
    }

    public Player(Long id, Long gameID) {
        super(id);
        this.gameID = gameID;
    }

    public Long getGameID() {
        return gameID;
    }

    public void setGameID(Long gameID) {
        this.gameID = gameID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Player player = (Player) o;
        return Objects.equals(gameID, player.gameID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), gameID);
    }

//    @ManyToOne
//    private Game game;
//
//    public Game getGame() {
//        return game;
//    }
//
//    public void setGame(Game manyToOne) {
//        this.game = manyToOne;
//    }
}
