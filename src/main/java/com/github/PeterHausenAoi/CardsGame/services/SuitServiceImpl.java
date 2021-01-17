package com.github.PeterHausenAoi.CardsGame.services;

import com.github.PeterHausenAoi.CardsGame.models.Game;
import com.github.PeterHausenAoi.CardsGame.models.exceptions.NotFoundException;
import com.github.PeterHausenAoi.CardsGame.models.messages.UndealtCardMeta;
import com.github.PeterHausenAoi.CardsGame.models.messages.UndealtSuitMeta;
import com.github.PeterHausenAoi.CardsGame.repositories.CardSuitRepository;
import com.github.PeterHausenAoi.CardsGame.repositories.GameRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SuitServiceImpl implements SuitService{
    private final GameRepository gameRepository;
    private final CardSuitRepository cardSuitRepository;

    public SuitServiceImpl(GameRepository gameRepository, CardSuitRepository cardSuitRepository) {
        this.gameRepository = gameRepository;
        this.cardSuitRepository = cardSuitRepository;
    }

    @Override
    public List<UndealtSuitMeta> getUndealtSuitMeta(Long gameID) throws NotFoundException {
        Game game = findGame(gameID);
        return cardSuitRepository.getUndealtSuitMeta(game.getId());
    }

    @Override
    public List<UndealtCardMeta> getUndealtCardMeta(Long gameID) throws NotFoundException {
        Game game = findGame(gameID);
        return cardSuitRepository.getUndealtCardMeta(game.getId());
    }

    private Game findGame(Long gameID) throws NotFoundException {
        Optional<Game> optGame = gameRepository.findById(gameID);

        if (!optGame.isPresent()){
            throw new NotFoundException("Game not found");
        }

        return optGame.get();
    }
}
