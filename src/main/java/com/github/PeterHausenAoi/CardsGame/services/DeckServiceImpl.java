package com.github.PeterHausenAoi.CardsGame.services;

import com.github.PeterHausenAoi.CardsGame.repositories.DeckRepository;
import org.springframework.stereotype.Service;

@Service
public class DeckServiceImpl implements DeckService {
    private final DeckRepository deckRepository;

    public DeckServiceImpl(DeckRepository deckRepository) {
        this.deckRepository = deckRepository;
    }
}
