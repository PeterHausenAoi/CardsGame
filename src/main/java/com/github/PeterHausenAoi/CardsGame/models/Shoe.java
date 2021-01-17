package com.github.PeterHausenAoi.CardsGame.models;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "shoes")
public class Shoe extends BaseEntity {
    @OneToOne
    @JoinColumn(name = "game_id", referencedColumnName = "id")
    private Game game;

    @OneToMany(mappedBy = "shoe", fetch = FetchType.LAZY)
    private Set<ShoeDeck> shoeDecks;

    public Shoe() {
    }

    public Shoe(Long id) {
        super(id);
    }

    public Shoe(Game game) {
        this.game = game;
    }

    public Shoe(Long id, Game game) {
        super(id);
        this.game = game;
    }


}
