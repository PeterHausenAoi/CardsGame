package com.github.PeterHausenAoi.CardsGame.services;

import com.github.PeterHausenAoi.CardsGame.models.CardSuit;
import com.github.PeterHausenAoi.CardsGame.models.CardValue;
import com.github.PeterHausenAoi.CardsGame.models.Deck;
import com.github.PeterHausenAoi.CardsGame.models.DeckCard;
import com.github.PeterHausenAoi.CardsGame.repositories.CardSuitRepository;
import com.github.PeterHausenAoi.CardsGame.repositories.CardValueRepository;
import com.github.PeterHausenAoi.CardsGame.repositories.DeckCardRepository;
import com.github.PeterHausenAoi.CardsGame.repositories.DeckRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class DeckServiceImpl implements DeckService {
    private final DeckRepository deckRepository;
    private final CardSuitRepository cardSuitRepository;
    private final CardValueRepository valueRepository;
    private final DeckCardRepository deckCardRepository;

    public DeckServiceImpl(DeckRepository deckRepository, CardSuitRepository cardSuitRepository, CardValueRepository valueRepository, DeckCardRepository deckCardRepository) {
        this.deckRepository = deckRepository;
        this.cardSuitRepository = cardSuitRepository;
        this.valueRepository = valueRepository;
        this.deckCardRepository = deckCardRepository;
    }

    @Override
    public Deck save(Deck deck) {
        deckRepository.save(deck);

        Iterable<CardSuit> suits = cardSuitRepository.findAll();
        Iterable<CardValue> values = valueRepository.findAll();

        List<DeckCard> newCards = new ArrayList<>();

        for (CardSuit suit : suits){
            for (CardValue value : values){
                newCards.add(new DeckCard(deck, suit, value));
            }
        }

        deckCardRepository.saveAll(newCards);

        return deck;
    }
}
