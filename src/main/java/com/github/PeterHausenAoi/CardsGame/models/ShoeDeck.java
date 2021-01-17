package com.github.PeterHausenAoi.CardsGame.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "shoe_decks")
public class ShoeDeck extends BaseEntity{
    @Column(name = "deck_id")
    private Long deckID;

    public ShoeDeck() {
    }

    public ShoeDeck(Long deckID) {
        this.deckID = deckID;
    }

    public ShoeDeck(Long id, Long deckID) {
        super(id);
        this.deckID = deckID;
    }

    public Long getDeckID() {
        return deckID;
    }

    public void setDeckID(Long deckID) {
        this.deckID = deckID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ShoeDeck shoeDeck = (ShoeDeck) o;
        return Objects.equals(deckID, shoeDeck.deckID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), deckID);
    }
}
