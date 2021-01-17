package com.github.PeterHausenAoi.CardsGame.services;

import com.github.PeterHausenAoi.CardsGame.models.Game;
import com.github.PeterHausenAoi.CardsGame.models.Player;
import com.github.PeterHausenAoi.CardsGame.repositories.GameRepository;
import com.github.PeterHausenAoi.CardsGame.repositories.PlayerRepository;
import com.github.PeterHausenAoi.CardsGame.repositories.ShoeCardRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
        Optional<Game> OptGame = gameRepository.findById(gameID);

        if (!OptGame.isPresent()){
            //TODO make exception
            throw new Exception("game not found");
        }

        Game game = OptGame.get();
        player.setGame(game);;

        playerRepository.save(player);

        return player;
    }
}
