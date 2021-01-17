package com.github.PeterHausenAoi.CardsGame.models;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "decks")
public class Deck extends BaseEntity{

    public Deck() {
    }

    public Deck(Long id) {
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
}
