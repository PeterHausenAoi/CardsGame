package com.github.PeterHausenAoi.CardsGame.repositories;

import com.github.PeterHausenAoi.CardsGame.models.DeckCard;
import org.springframework.data.repository.CrudRepository;

public interface DeckCardRepository extends CrudRepository<DeckCard, Long> {
}
