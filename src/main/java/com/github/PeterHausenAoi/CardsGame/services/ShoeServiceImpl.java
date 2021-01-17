package com.github.PeterHausenAoi.CardsGame.services;

import com.github.PeterHausenAoi.CardsGame.models.*;
import com.github.PeterHausenAoi.CardsGame.repositories.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ShoeServiceImpl implements ShoeService {
    private final GameRepository gameRepository;
    private final DeckRepository deckRepository;
    private final ShoeRepository shoeRepository;
    private final ShoeDeckRepository shoeDeckRepository;
    private final ShoeCardRepository shoeCardRepository;

    public ShoeServiceImpl(GameRepository gameRepository, DeckRepository deckRepository, ShoeRepository shoeRepository, ShoeDeckRepository shoeDeckRepository, ShoeCardRepository shoeCardRepository) {
        this.gameRepository = gameRepository;
        this.deckRepository = deckRepository;
        this.shoeRepository = shoeRepository;
        this.shoeDeckRepository = shoeDeckRepository;
        this.shoeCardRepository = shoeCardRepository;
    }

    @Override
    public void addDeckToShoe(Long gameID, Long deckID) throws Exception {
        Optional<Game> OptGame = gameRepository.findById(gameID);

        if (!OptGame.isPresent()){
            //TODO make exception
            throw new Exception("game not found");
        }

        Optional<Deck> OptDeck = deckRepository.findById(deckID);

        if (!OptDeck.isPresent()){
            //TODO make exception
            throw new Exception("deck not found");
        }

        Game game = OptGame.get();
        Deck deck = OptDeck.get();

        if(game.getShoe() == null){
            throw new Exception("shoe not found");
        }

        Optional<ShoeDeck> optPrevShoeDeck = shoeDeckRepository.findByDeckId(deckID);

        if (optPrevShoeDeck.isPresent()){
            throw new Exception("deck already added to game");
        }

        Long maxOrdinalPosition = -1L;

        for(ShoeDeck shoeDeck : game.getShoe().getShoeDecks()){
            for (ShoeCard shoeCard : shoeDeck.getShoeCards()){
                if (shoeCard.getOrdinalPosition() > maxOrdinalPosition){
                    maxOrdinalPosition = shoeCard.getOrdinalPosition();
                }
            }
        }

        ShoeDeck shoeDeck = new ShoeDeck(deck, game.getShoe());
        shoeDeckRepository.save(shoeDeck);

        List<ShoeCard> shoeCards = new ArrayList<>();

        for (DeckCard deckCard : deck.getDeckCards()){
            shoeCards.add(new ShoeCard(shoeDeck, deckCard, null, ++maxOrdinalPosition, false));
        }

        shoeCardRepository.saveAll(shoeCards);
    }
}
