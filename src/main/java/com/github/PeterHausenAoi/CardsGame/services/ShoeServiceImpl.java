package com.github.PeterHausenAoi.CardsGame.services;

import com.github.PeterHausenAoi.CardsGame.repositories.ShoeCardRepository;
import com.github.PeterHausenAoi.CardsGame.repositories.ShoeDeckRepository;
import com.github.PeterHausenAoi.CardsGame.repositories.ShoeRepository;
import org.springframework.stereotype.Service;

@Service
public class ShoeServiceImpl implements ShoeService {
    private final ShoeRepository shoeRepository;
    private final ShoeDeckRepository deckRepository;
    private final ShoeCardRepository shoeCardRepository;

    public ShoeServiceImpl(ShoeRepository shoeRepository, ShoeDeckRepository deckRepository, ShoeCardRepository shoeCardRepository) {
        this.shoeRepository = shoeRepository;
        this.deckRepository = deckRepository;
        this.shoeCardRepository = shoeCardRepository;
    }
}
