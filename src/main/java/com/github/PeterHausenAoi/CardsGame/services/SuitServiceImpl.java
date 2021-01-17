package com.github.PeterHausenAoi.CardsGame.services;

import com.github.PeterHausenAoi.CardsGame.repositories.CardSuitRepository;
import org.springframework.stereotype.Service;

@Service
public class SuitServiceImpl implements SuitService{
    private final CardSuitRepository cardSuitRepository;

    public SuitServiceImpl(CardSuitRepository cardSuitRepository) {
        this.cardSuitRepository = cardSuitRepository;
    }
}
