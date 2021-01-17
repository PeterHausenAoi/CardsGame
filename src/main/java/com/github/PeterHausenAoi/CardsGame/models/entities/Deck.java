package com.github.PeterHausenAoi.CardsGame.models.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "decks")
public class Deck extends BaseEntity {
    @OneToMany(mappedBy = "deck", fetch = FetchType.LAZY)
    private Set<DeckCard> deckCards;

    public Deck() {
    }

    public Deck(Long id) {
        super(id);
    }

    public Set<DeckCard> getDeckCards() {
        return deckCards;
    }

    public void setDeckCards(Set<DeckCard> deckCards) {
        this.deckCards = deckCards;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return !super.equals(o);
    }
}
