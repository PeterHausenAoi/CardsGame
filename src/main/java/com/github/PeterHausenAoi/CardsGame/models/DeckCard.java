package com.github.PeterHausenAoi.CardsGame.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "deck_cards")
public class DeckCard extends BaseEntity {
    @Column(name = "card_suit_id")
    private Long cardSuitID;

    @Column(name = "card_value_id")
    private Long cardValueID;

    public DeckCard() {
    }

    public DeckCard(Long id) {
        super(id);
    }

    public DeckCard(Long cardSuitID, Long cardValueID) {
        this.cardSuitID = cardSuitID;
        this.cardValueID = cardValueID;
    }

    public DeckCard(Long id, Long cardSuitID, Long cardValueID) {
        super(id);
        this.cardSuitID = cardSuitID;
        this.cardValueID = cardValueID;
    }

    public Long getCardSuitID() {
        return cardSuitID;
    }

    public void setCardSuitID(Long cardSuitID) {
        this.cardSuitID = cardSuitID;
    }

    public Long getCardValueID() {
        return cardValueID;
    }

    public void setCardValueID(Long cardValueID) {
        this.cardValueID = cardValueID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DeckCard deckCard = (DeckCard) o;
        return Objects.equals(cardSuitID, deckCard.cardSuitID) && Objects.equals(cardValueID, deckCard.cardValueID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), cardSuitID, cardValueID);
    }
}
