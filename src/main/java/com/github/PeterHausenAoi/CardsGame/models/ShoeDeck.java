package com.github.PeterHausenAoi.CardsGame.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "shoe_decks")
public class ShoeDeck extends BaseEntity{
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "deck_id", nullable = false)
    private Deck deck;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shoe_id", nullable = false)
    private Shoe shoe;

    public ShoeDeck() {
    }

    public ShoeDeck(Long id) {
        super(id);
    }

    public ShoeDeck(Deck deck, Shoe shoe) {
        this.deck = deck;
        this.shoe = shoe;
    }

    public ShoeDeck(Long id, Deck deck, Shoe shoe) {
        super(id);
        this.deck = deck;
        this.shoe = shoe;
    }

    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public Shoe getShoe() {
        return shoe;
    }

    public void setShoe(Shoe shoe) {
        this.shoe = shoe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ShoeDeck shoeDeck = (ShoeDeck) o;
        return Objects.equals(deck, shoeDeck.deck) && Objects.equals(shoe, shoeDeck.shoe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), deck, shoe);
    }
}
