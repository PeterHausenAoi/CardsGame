package com.github.PeterHausenAoi.CardsGame.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "games")
@JsonIgnoreProperties(ignoreUnknown = true, value = {"shoe", "players"})
public class Game extends BaseEntity {
    @OneToOne(mappedBy = "game", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private Shoe shoe;

    @OneToMany(mappedBy = "game", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
    private Set<Player> players;

    public Game() {
    }

    public Game(Long id) {
        super(id);
    }

    public Long findMaxOrdinalPosition(){
        Long maxOrdinalPosition = -1L;

        for(ShoeDeck shoeDeck : getShoe().getShoeDecks()){
            for (ShoeCard shoeCard : shoeDeck.getShoeCards()){
                if (shoeCard.getOrdinalPosition() > maxOrdinalPosition){
                    maxOrdinalPosition = shoeCard.getOrdinalPosition();
                }
            }
        }

        return maxOrdinalPosition;
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
        return !super.equals(o);
    }
}
