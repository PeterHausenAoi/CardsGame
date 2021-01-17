package com.github.PeterHausenAoi.CardsGame.services;

import com.github.PeterHausenAoi.CardsGame.models.entities.*;
import com.github.PeterHausenAoi.CardsGame.models.exceptions.NotFoundException;
import com.github.PeterHausenAoi.CardsGame.models.exceptions.ValidationException;
import com.github.PeterHausenAoi.CardsGame.repositories.*;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class ShoeServiceImpl implements ShoeService {
    private final GameRepository gameRepository;
    private final DeckRepository deckRepository;
    private final ShoeDeckRepository shoeDeckRepository;
    private final ShoeCardRepository shoeCardRepository;
    private final PlayerRepository playerRepository;

    public ShoeServiceImpl(GameRepository gameRepository, DeckRepository deckRepository, ShoeDeckRepository shoeDeckRepository, ShoeCardRepository shoeCardRepository, PlayerRepository playerRepository) {
        this.gameRepository = gameRepository;
        this.deckRepository = deckRepository;
        this.shoeDeckRepository = shoeDeckRepository;
        this.shoeCardRepository = shoeCardRepository;
        this.playerRepository = playerRepository;
    }

    /**
     * Adds cards from a deck to a game with valid deal orders
     */
    @Transactional(rollbackOn = {SQLException.class})
    @Override
    public void addDeckToShoe(Long gameID, Long deckID) throws NotFoundException, ValidationException {
        Game game = findGame(gameID);
        Deck deck = findDeck(deckID);

        if(game.getShoe() == null){
            throw new NotFoundException("Shoe not found");
        }

        Optional<ShoeDeck> optPrevShoeDeck = shoeDeckRepository.findByDeckId(deckID);

        if (optPrevShoeDeck.isPresent()){
            throw new ValidationException("Deck already added to game");
        }

        Long maxOrdinalPosition = game.findMaxOrdinalPosition();

        ShoeDeck shoeDeck = new ShoeDeck(deck, game.getShoe());
        shoeDeckRepository.save(shoeDeck);

        List<ShoeCard> shoeCards = new ArrayList<>();

        for (DeckCard deckCard : deck.getDeckCards()){
            shoeCards.add(new ShoeCard(shoeDeck, deckCard, null, ++maxOrdinalPosition, false));
        }

        shoeCardRepository.saveAll(shoeCards);
    }

    /**
     * Deals the next card to a given player
     * Discarded cards are not being redealt.
     */
    @Transactional(rollbackOn = {SQLException.class})
    @Override
    public ShoeCard dealToPlayer(Long gameID, Long playerID) throws NotFoundException {
        findGame(gameID);
        Player player = findPlayer(playerID);

        Optional<ShoeCard> optShoeCard = shoeCardRepository.getNextCard(gameID);

        if(!optShoeCard.isPresent()){
            return null;
        }

        ShoeCard shoeCard = optShoeCard.get();

        shoeCard.setPlayer(player);
        shoeCardRepository.save(shoeCard);

        return shoeCard;
    }

    /**
     * Fisher–Yates shuffle algorithm
     */
    @Transactional(rollbackOn = {SQLException.class})
    @Override
    public void shuffleShoe(Long gameID) throws NotFoundException {
        Game game = findGame(gameID);
        List<ShoeCard> unusedCards = new ArrayList<>();

        game.getShoe().getShoeDecks().forEach(shoeDeck ->
            shoeDeck.getShoeCards().stream().filter(
                    shoeCard -> !shoeCard.getDiscarded() && shoeCard.getPlayer() == null
            ).forEach(unusedCards::add)
        );

        if (unusedCards.size() == 0){
            return;
        }

        Random rand = new Random();

        for (ShoeCard card : unusedCards){
            int switchPos = rand.nextInt(unusedCards.size());

            ShoeCard other = unusedCards.get(switchPos);
            Long otherOrdinal = other.getOrdinalPosition();
            other.setOrdinalPosition(card.getOrdinalPosition());

            card.setOrdinalPosition(otherOrdinal);
        }

        shoeCardRepository.saveAll(unusedCards);
    }

    private Deck findDeck(Long deckID) throws NotFoundException {
        Optional<Deck> optDeck = deckRepository.findById(deckID);

        if (!optDeck.isPresent()){
            throw new NotFoundException("Deck not found");
        }

        return optDeck.get();
    }

    private Game findGame(Long gameID) throws NotFoundException {
        Optional<Game> optGame = gameRepository.findById(gameID);

        if (!optGame.isPresent()){
            throw new NotFoundException("Game not found");
        }

        return optGame.get();
    }

    private Player findPlayer(Long playerID) throws NotFoundException {
        Optional<Player> optPlayer = playerRepository.findById(playerID);

        if(!optPlayer.isPresent()){
            throw new NotFoundException("Player not found");
        }

        return optPlayer.get();
    }
}
