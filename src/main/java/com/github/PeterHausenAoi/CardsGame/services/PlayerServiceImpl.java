package com.github.PeterHausenAoi.CardsGame.services;

import com.github.PeterHausenAoi.CardsGame.repositories.PlayerRepository;
import com.github.PeterHausenAoi.CardsGame.repositories.ShoeCardRepository;
import org.springframework.stereotype.Service;

@Service
public class PlayerServiceImpl implements PlayerService{
    private final PlayerRepository playerRepository;
    private final ShoeCardRepository shoeCardRepository;

    public PlayerServiceImpl(PlayerRepository playerRepository, ShoeCardRepository shoeCardRepository) {
        this.playerRepository = playerRepository;
        this.shoeCardRepository = shoeCardRepository;
    }
}
