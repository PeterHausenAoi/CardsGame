package com.github.PeterHausenAoi.CardsGame.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "deck_cards")
public class DeckCard extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "deck_id", nullable = false)
    private Deck deck;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "card_suit_id", nullable = false)
    private CardSuit cardSuit;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "card_value_id", nullable = false)
    private CardValue cardValue;

    public DeckCard() {
    }

    public DeckCard(Long id) {
        super(id);
    }

    public DeckCard(Deck deck, CardSuit cardSuit, CardValue cardValue) {
        this.deck = deck;
        this.cardSuit = cardSuit;
        this.cardValue = cardValue;
    }

    public DeckCard(Long id, Deck deck, CardSuit cardSuit, CardValue cardValue) {
        super(id);
        this.deck = deck;
        this.cardSuit = cardSuit;
        this.cardValue = cardValue;
    }

    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public CardSuit getCardSuit() {
        return cardSuit;
    }

    public void setCardSuit(CardSuit cardSuit) {
        this.cardSuit = cardSuit;
    }

    public CardValue getCardValue() {
        return cardValue;
    }

    public void setCardValue(CardValue cardValue) {
        this.cardValue = cardValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return !super.equals(o);
    }
}
