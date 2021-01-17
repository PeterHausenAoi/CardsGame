package com.github.PeterHausenAoi.CardsGame.services;

import com.github.PeterHausenAoi.CardsGame.models.Game;
import com.github.PeterHausenAoi.CardsGame.models.Shoe;
import com.github.PeterHausenAoi.CardsGame.repositories.GameRepository;
import com.github.PeterHausenAoi.CardsGame.repositories.ShoeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GameServiceImpl implements GameService{
    private final GameRepository gameRepository;
    private final ShoeRepository shoeRepository;

    public GameServiceImpl(GameRepository gameRepository, ShoeRepository shoeRepository) {
        this.gameRepository = gameRepository;
        this.shoeRepository = shoeRepository;
    }

    @Override
    public Game save(Game game) {
        gameRepository.save(game);

        Shoe shoe = new Shoe(game);
        shoeRepository.save(shoe);

        return gameRepository.save(game);
    }

    @Override
    public void delete(Long gameID) throws Exception {
        Optional<Game> optGame = gameRepository.findById(gameID);

        if (!optGame.isPresent()){
            //TODO make exception
            throw new Exception("game not found");
        }

        Game game = optGame.get();
        gameRepository.delete(game);
    }
}
