package com.github.PeterHausenAoi.CardsGame.services;

import com.github.PeterHausenAoi.CardsGame.models.Player;
import com.github.PeterHausenAoi.CardsGame.models.messages.PlayerCard;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface PlayerService {
    Player save(Player player, Long gameID) throws Exception;
    List<PlayerCard> getPlayerCards(@PathVariable Long gameID, @PathVariable Long playerID) throws Exception;
}
