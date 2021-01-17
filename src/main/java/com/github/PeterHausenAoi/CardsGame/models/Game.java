package com.github.PeterHausenAoi.CardsGame.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "games")
public class Game extends BaseEntity {
    @OneToOne(mappedBy = "game", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private Shoe Shoe;

    public Game() {
    }

    public Game(Long id) {
        super(id);
    }

    public Shoe getShoe() {
        return Shoe;
    }

    public void setShoe(Shoe shoe) {
        Shoe = shoe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return !super.equals(o);
    }
}
