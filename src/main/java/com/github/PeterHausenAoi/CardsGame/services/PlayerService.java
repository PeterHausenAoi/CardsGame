package com.github.PeterHausenAoi.CardsGame.services;

import com.github.PeterHausenAoi.CardsGame.models.Player;

public interface PlayerService {
    Player save(Player player, Long gameID) throws Exception;
}
