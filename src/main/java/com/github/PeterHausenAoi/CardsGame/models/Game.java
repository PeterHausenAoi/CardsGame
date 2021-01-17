package com.github.PeterHausenAoi.CardsGame.models;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "games")
public class Game extends BaseEntity {
    @OneToOne(mappedBy = "game")
    private Shoe Shoe;

    public Game() {
    }

    public Game(Long id) {
        super(id);
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public Shoe getShoe() {
        return Shoe;
    }

    public void setShoe(Shoe shoe) {
        Shoe = shoe;
    }
}
