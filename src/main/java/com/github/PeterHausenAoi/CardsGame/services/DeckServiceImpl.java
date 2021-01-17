package com.github.PeterHausenAoi.CardsGame.services;

import com.github.PeterHausenAoi.CardsGame.models.entities.CardSuit;
import com.github.PeterHausenAoi.CardsGame.models.entities.CardValue;
import com.github.PeterHausenAoi.CardsGame.models.entities.Deck;
import com.github.PeterHausenAoi.CardsGame.models.entities.DeckCard;
import com.github.PeterHausenAoi.CardsGame.repositories.CardSuitRepository;
import com.github.PeterHausenAoi.CardsGame.repositories.CardValueRepository;
import com.github.PeterHausenAoi.CardsGame.repositories.DeckCardRepository;
import com.github.PeterHausenAoi.CardsGame.repositories.DeckRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    /**
     * Stores cards for deck alongside the deck itself
     */
    @Transactional(rollbackOn = {SQLException.class})
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
