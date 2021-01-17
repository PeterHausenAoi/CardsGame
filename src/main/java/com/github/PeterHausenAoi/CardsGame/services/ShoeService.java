package com.github.PeterHausenAoi.CardsGame.services;

import com.github.PeterHausenAoi.CardsGame.models.ShoeCard;
import com.github.PeterHausenAoi.CardsGame.models.exceptions.NotFoundException;
import com.github.PeterHausenAoi.CardsGame.models.exceptions.ValidationException;

public interface ShoeService {
    void addDeckToShoe(Long gameID, Long deckID) throws NotFoundException, ValidationException;
    ShoeCard dealToPlayer(Long gameID, Long playerID) throws NotFoundException;
    void shuffleShoe(Long gameID) throws NotFoundException;
}
