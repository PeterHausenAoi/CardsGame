package com.github.PeterHausenAoi.CardsGame.services;

import com.github.PeterHausenAoi.CardsGame.models.entities.Player;
import com.github.PeterHausenAoi.CardsGame.models.exceptions.NotFoundException;
import com.github.PeterHausenAoi.CardsGame.models.messages.PlayerCard;
import com.github.PeterHausenAoi.CardsGame.models.messages.PlayerState;

import java.util.List;

public interface PlayerService {
    Player save(Player player, Long gameID) throws NotFoundException;
    List<PlayerCard> getPlayerCards(Long gameID, Long playerID) throws NotFoundException;
    List<PlayerState> getPlayerStates(Long gameID) throws NotFoundException;
    void delete(Long gameID, Long playerID) throws NotFoundException;
}
