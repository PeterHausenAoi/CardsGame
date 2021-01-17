package com.github.PeterHausenAoi.CardsGame.repositories;

import com.github.PeterHausenAoi.CardsGame.models.Game;
import org.springframework.data.repository.CrudRepository;

public interface GameRepository extends CrudRepository<Game, Long> {
}
