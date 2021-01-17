package com.github.PeterHausenAoi.CardsGame.services;

import com.github.PeterHausenAoi.CardsGame.models.Player;
import com.github.PeterHausenAoi.CardsGame.models.messages.PlayerCard;
import com.github.PeterHausenAoi.CardsGame.models.messages.PlayerState;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface PlayerService {
    Player save(Player player, Long gameID) throws Exception;
    List<PlayerCard> getPlayerCards(Long gameID, Long playerID) throws Exception;
    List<PlayerState> getPlayerStates(Long gameID) throws Exception;
}
