package com.github.PeterHausenAoi.CardsGame.services;

import com.github.PeterHausenAoi.CardsGame.models.Game;
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
    public List<UndealtSuitMeta> getUndealtSuitMeta(Long gameID) throws Exception {
        Optional<Game> optGame = gameRepository.findById(gameID);

        if (!optGame.isPresent()){
            //TODO make exception
            throw new Exception("game not found");
        }

        return cardSuitRepository.getUndealtSuitMeta(gameID);
    }

    @Override
    public List<UndealtCardMeta> getUndealtCardMeta(Long gameID) throws Exception {
        Optional<Game> optGame = gameRepository.findById(gameID);

        if (!optGame.isPresent()){
            //TODO make exception
            throw new Exception("game not found");
        }

        return cardSuitRepository.getUndealtCardMeta(gameID);
    }
}
