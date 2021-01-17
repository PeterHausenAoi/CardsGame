package com.github.PeterHausenAoi.CardsGame.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "shoes")
public class Shoe extends BaseEntity {
    @Column(name = "game_id")
    private Long gameID;

    public Shoe() {
    }

    public Shoe(Long gameID) {
        this.gameID = gameID;
    }

    public Shoe(Long id, Long gameID) {
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
        Shoe shoe = (Shoe) o;
        return Objects.equals(gameID, shoe.gameID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), gameID);
    }
}
