package com.github.PeterHausenAoi.CardsGame.services;

import com.github.PeterHausenAoi.CardsGame.models.ShoeCard;
import org.springframework.web.bind.annotation.PathVariable;

public interface ShoeService {
    void addDeckToShoe(Long gameID, Long deckID) throws Exception;
    ShoeCard dealToPlayer(Long gameID, Long playerID) throws Exception;
}
