package com.github.PeterHausenAoi.CardsGame.services;

import com.github.PeterHausenAoi.CardsGame.models.Game;
import com.github.PeterHausenAoi.CardsGame.models.exceptions.NotFoundException;

public interface GameService{
    Game save(Game game);
    void delete(Long gameID) throws NotFoundException;
}
