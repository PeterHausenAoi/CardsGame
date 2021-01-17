package com.github.PeterHausenAoi.CardsGame.repositories;

import com.github.PeterHausenAoi.CardsGame.models.Deck;
import org.springframework.data.repository.CrudRepository;

public interface DeckRepository extends CrudRepository<Deck, Long> {
}
