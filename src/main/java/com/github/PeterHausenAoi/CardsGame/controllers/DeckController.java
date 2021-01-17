package com.github.PeterHausenAoi.CardsGame.controllers;

import com.github.PeterHausenAoi.CardsGame.services.DeckService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/decks")
public class DeckController {
    private final DeckService deckService;

    public DeckController(DeckService deckService) {
        this.deckService = deckService;
    }

    @PostMapping(value = "/", produces = "application/json")
    public String createDeck(){
        // TODO return new deck POJO
        return "";
    }

}
