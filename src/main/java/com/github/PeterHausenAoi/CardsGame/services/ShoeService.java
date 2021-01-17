package com.github.PeterHausenAoi.CardsGame.services;

import org.springframework.web.bind.annotation.PathVariable;

public interface ShoeService {
    void addDeckToShoe(Long gameID, Long deckID) throws Exception;
}
