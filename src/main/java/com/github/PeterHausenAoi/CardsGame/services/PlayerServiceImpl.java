package com.github.PeterHausenAoi.CardsGame.services;

import com.github.PeterHausenAoi.CardsGame.models.entities.Game;
import com.github.PeterHausenAoi.CardsGame.models.entities.Player;
import com.github.PeterHausenAoi.CardsGame.models.exceptions.NotFoundException;
import com.github.PeterHausenAoi.CardsGame.models.messages.PlayerCard;
import com.github.PeterHausenAoi.CardsGame.models.messages.PlayerState;
import com.github.PeterHausenAoi.CardsGame.repositories.GameRepository;
import com.github.PeterHausenAoi.CardsGame.repositories.PlayerRepository;
import com.github.PeterHausenAoi.CardsGame.repositories.ShoeCardRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlayerServiceImpl implements PlayerService{
    private final GameRepository gameRepository;
    private final PlayerRepository playerRepository;
    private final ShoeCardRepository shoeCardRepository;

    public PlayerServiceImpl(GameRepository gameRepository, PlayerRepository playerRepository, ShoeCardRepository shoeCardRepository) {
        this.gameRepository = gameRepository;
        this.playerRepository = playerRepository;
        this.shoeCardRepository = shoeCardRepository;
    }

    @Transactional(rollbackOn = {SQLException.class})
    @Override
    public Player save(Player player, Long gameID) throws NotFoundException {
        Game game = findGame(gameID);
        player.setGame(game);

        playerRepository.save(player);

        return player;
    }

    @Override
    public List<PlayerCard> getPlayerCards(Long gameID, Long playerID) throws NotFoundException {
        findGame(gameID);
        Player player = findPlayer(playerID);

        return player.getShoeCards().stream().map(shoeCard ->
                new PlayerCard(shoeCard.getDeckCard().getCardSuit().getName(),
                        shoeCard.getDeckCard().getCardValue().getName(),
                        shoeCard.getDeckCard().getCardValue().getValue())).collect(Collectors.toList());
    }

    @Override
    public List<PlayerState> getPlayerStates(Long gameID) throws NotFoundException {
        Game game = findGame(gameID);
        List<Player> players = playerRepository.findAllByGameId(game.getId());

        return players.stream().map(player -> new PlayerState(
                player.getId(),
                player.getShoeCards().stream().mapToLong(value -> value.getDeckCard().getCardValue().getValue()).sum()
        )).collect(Collectors.toList());
    }

    @Transactional(rollbackOn = {SQLException.class})
    @Override
    public void delete(Long gameID, Long playerID) throws NotFoundException {
        findGame(gameID);
        Player player = findPlayer(playerID);

        shoeCardRepository.discardPlayerCards(playerID);
        playerRepository.delete(player);
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
            throw new NotFoundException("player not found");
        }

        return optPlayer.get();
    }
}
