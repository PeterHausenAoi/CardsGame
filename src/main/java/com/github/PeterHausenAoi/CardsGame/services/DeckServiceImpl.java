package com.github.PeterHausenAoi.CardsGame.services;

import com.github.PeterHausenAoi.CardsGame.models.Deck;
import com.github.PeterHausenAoi.CardsGame.repositories.DeckRepository;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class DeckServiceImpl implements DeckService {
    private final DeckRepository deckRepository;

    public DeckServiceImpl(DeckRepository deckRepository) {
        this.deckRepository = deckRepository;
    }

    @Override
    public Deck save(Deck deck) {
        return deckRepository.save(deck);
    }
}
