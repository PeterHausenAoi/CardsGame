package com.github.PeterHausenAoi.CardsGame.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "shoe_cards")
public class ShoeCard extends  BaseEntity{
    @Column(name = "shoe_deck_id")
    private Long shoeDeckID;

    @Column(name = "deck_card_id")
    private Long deckCardID;

    @Column(name = "ordinal_position")
    private Long ordinalPosition;

    @Column(name = "player_id")
    private Long playerID;

    @Column(name = "discarded")
    private Boolean discarded;

    public ShoeCard() {
    }

    public ShoeCard(Long id) {
        super(id);
    }

    public ShoeCard(Long shoeDeckID, Long deckCardID, Long ordinalPosition, Long playerID, Boolean discarded) {
        this.shoeDeckID = shoeDeckID;
        this.deckCardID = deckCardID;
        this.ordinalPosition = ordinalPosition;
        this.playerID = playerID;
        this.discarded = discarded;
    }

    public ShoeCard(Long id, Long shoeDeckID, Long deckCardID, Long ordinalPosition, Long playerID, Boolean discarded) {
        super(id);
        this.shoeDeckID = shoeDeckID;
        this.deckCardID = deckCardID;
        this.ordinalPosition = ordinalPosition;
        this.playerID = playerID;
        this.discarded = discarded;
    }

    public Long getShoeDeckID() {
        return shoeDeckID;
    }

    public void setShoeDeckID(Long shoeDeckID) {
        this.shoeDeckID = shoeDeckID;
    }

    public Long getDeckCardID() {
        return deckCardID;
    }

    public void setDeckCardID(Long deckCardID) {
        this.deckCardID = deckCardID;
    }

    public Long getOrdinalPosition() {
        return ordinalPosition;
    }

    public void setOrdinalPosition(Long ordinalPosition) {
        this.ordinalPosition = ordinalPosition;
    }

    public Long getPlayerID() {
        return playerID;
    }

    public void setPlayerID(Long playerID) {
        this.playerID = playerID;
    }

    public Boolean getDiscarded() {
        return discarded;
    }

    public void setDiscarded(Boolean discarded) {
        this.discarded = discarded;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ShoeCard shoeCard = (ShoeCard) o;
        return Objects.equals(shoeDeckID, shoeCard.shoeDeckID) && Objects.equals(deckCardID, shoeCard.deckCardID) && Objects.equals(ordinalPosition, shoeCard.ordinalPosition) && Objects.equals(playerID, shoeCard.playerID) && Objects.equals(discarded, shoeCard.discarded);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), shoeDeckID, deckCardID, ordinalPosition, playerID, discarded);
    }
}
