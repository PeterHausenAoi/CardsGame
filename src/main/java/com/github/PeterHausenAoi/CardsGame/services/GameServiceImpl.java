package com.github.PeterHausenAoi.CardsGame.services;

import com.github.PeterHausenAoi.CardsGame.models.entities.Game;
import com.github.PeterHausenAoi.CardsGame.models.entities.Shoe;
import com.github.PeterHausenAoi.CardsGame.models.exceptions.NotFoundException;
import com.github.PeterHausenAoi.CardsGame.repositories.GameRepository;
import com.github.PeterHausenAoi.CardsGame.repositories.ShoeRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.Optional;

@Service
public class GameServiceImpl implements GameService{
    private final GameRepository gameRepository;
    private final ShoeRepository shoeRepository;

    public GameServiceImpl(GameRepository gameRepository, ShoeRepository shoeRepository) {
        this.gameRepository = gameRepository;
        this.shoeRepository = shoeRepository;
    }

//    @Transactional(rollbackOn = {SQLException.class})
    @Override
    public Game save(Game game) {
        gameRepository.save(game);

        Shoe shoe = new Shoe(game);
        shoeRepository.save(shoe);

        return gameRepository.save(game);
    }

    @Transactional(rollbackOn = {SQLException.class})
    @Override
    public void delete(Long gameID) throws NotFoundException {
        Game game = findGame(gameID);
        gameRepository.delete(game);
    }

    private Game findGame(Long gameID) throws NotFoundException {
        Optional<Game> optGame = gameRepository.findById(gameID);

        if (!optGame.isPresent()){
            throw new NotFoundException("Game not found");
        }

        return optGame.get();
    }
}
