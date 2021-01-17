package com.github.PeterHausenAoi.CardsGame.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "decks")
public class Deck extends BaseEntity{
    @OneToMany(mappedBy = "deck", fetch = FetchType.LAZY)
    private Set<DeckCard> deckCards;

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

    public Set<DeckCard> getDeckCards() {
        return deckCards;
    }

    public void setDeckCards(Set<DeckCard> deckCards) {
        this.deckCards = deckCards;
    }
}
