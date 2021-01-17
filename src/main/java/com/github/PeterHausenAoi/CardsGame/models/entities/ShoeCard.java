package com.github.PeterHausenAoi.CardsGame.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "shoe_cards")
@JsonIgnoreProperties({ "shoeDeck", "deckCard", "player" })
public class ShoeCard extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shoe_deck_id", nullable = false)
    private ShoeDeck shoeDeck;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "deck_card_id", nullable = false)
    private DeckCard deckCard;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "player_id", nullable = true)
    private Player player;

    @Column(name = "ordinal_position")
    private Long ordinalPosition;

    @Column(name = "discarded")
    private Boolean discarded;

    public ShoeCard() {
    }

    public ShoeCard(Long id) {
        super(id);
    }

    public ShoeCard(ShoeDeck shoeDeck, DeckCard deckCard, Player player, Long ordinalPosition, Boolean discarded) {
        this.shoeDeck = shoeDeck;
        this.deckCard = deckCard;
        this.player = player;
        this.ordinalPosition = ordinalPosition;
        this.discarded = discarded;
    }

    public ShoeCard(Long id, ShoeDeck shoeDeck, DeckCard deckCard, Player player, Long ordinalPosition, Boolean discarded) {
        super(id);
        this.shoeDeck = shoeDeck;
        this.deckCard = deckCard;
        this.player = player;
        this.ordinalPosition = ordinalPosition;
        this.discarded = discarded;
    }

    public ShoeDeck getShoeDeck() {
        return shoeDeck;
    }

    public void setShoeDeck(ShoeDeck shoeDeck) {
        this.shoeDeck = shoeDeck;
    }

    public DeckCard getDeckCard() {
        return deckCard;
    }

    public void setDeckCard(DeckCard deckCard) {
        this.deckCard = deckCard;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Long getOrdinalPosition() {
        return ordinalPosition;
    }

    public void setOrdinalPosition(Long ordinalPosition) {
        this.ordinalPosition = ordinalPosition;
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
        return !super.equals(o);
    }
}
