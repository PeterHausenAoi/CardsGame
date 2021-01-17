package com.github.PeterHausenAoi.CardsGame.repositories;

import com.github.PeterHausenAoi.CardsGame.models.entities.ShoeDeck;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ShoeDeckRepository extends CrudRepository<ShoeDeck, Long> {
    Optional<ShoeDeck> findByDeckId(Long deckID);
}
