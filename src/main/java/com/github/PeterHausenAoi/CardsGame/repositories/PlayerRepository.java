package com.github.PeterHausenAoi.CardsGame.repositories;

import com.github.PeterHausenAoi.CardsGame.models.Player;
import org.springframework.data.repository.CrudRepository;

public interface PlayerRepository extends CrudRepository<Player, Long> {

}
