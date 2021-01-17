package com.github.PeterHausenAoi.CardsGame.services;

import com.github.PeterHausenAoi.CardsGame.models.Game;
import com.github.PeterHausenAoi.CardsGame.models.Player;
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

    @Override
    public Player save(Player player, Long gameID) throws Exception {
        Optional<Game> optGame = gameRepository.findById(gameID);

        if (!optGame.isPresent()){
            //TODO make exception
            throw new Exception("game not found");
        }

        Game game = optGame.get();
        player.setGame(game);

        playerRepository.save(player);

        return player;
    }

    @Override
    public List<PlayerCard> getPlayerCards(Long gameID, Long playerID) throws Exception {
        Optional<Game> optGame = gameRepository.findById(gameID);

        if (!optGame.isPresent()){
            //TODO make exception
            throw new Exception("game not found");
        }

        Optional<Player> optPlayer = playerRepository.findById(playerID);

        if(!optPlayer.isPresent()){
            throw new Exception("player not found");
        }

        Player player = optPlayer.get();

        return player.getShoeCards().stream().map(shoeCard ->
                new PlayerCard(shoeCard.getDeckCard().getCardSuit().getName(),
                        shoeCard.getDeckCard().getCardValue().getName(),
                        shoeCard.getDeckCard().getCardValue().getValue())).collect(Collectors.toList());
    }

    @Override
    public List<PlayerState> getPlayerStates(Long gameID) throws Exception {
        Optional<Game> optGame = gameRepository.findById(gameID);

        if (!optGame.isPresent()){
            //TODO make exception
            throw new Exception("game not found");
        }

        List<Player> players = playerRepository.findAllByGameId(optGame.get().getId());

        return players.stream().map(player -> new PlayerState(
                player.getId(),
                player.getShoeCards().stream().mapToLong(value -> value.getDeckCard().getCardValue().getValue()).sum()
        )).collect(Collectors.toList());
    }

    @Transactional(rollbackOn = {SQLException.class})
    @Override
    public void delete(Long gameID, Long playerID) throws Exception {
        Optional<Game> optGame = gameRepository.findById(gameID);

        if (!optGame.isPresent()){
            //TODO make exception
            throw new Exception("game not found");
        }

        Optional<Player> optPlayer = playerRepository.findById(playerID);

        if(!optPlayer.isPresent()){
            throw new Exception("player not found");
        }

        shoeCardRepository.discardPlayerCards(playerID);

        Player player = optPlayer.get();
        playerRepository.delete(player);
    }
}
