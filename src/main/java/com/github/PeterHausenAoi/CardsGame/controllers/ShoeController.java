package com.github.PeterHausenAoi.CardsGame.controllers;

import com.github.PeterHausenAoi.CardsGame.models.ShoeCard;
import com.github.PeterHausenAoi.CardsGame.services.ShoeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/games/{gameID}/shoes")
public class ShoeController {
    private final ShoeService shoeService;

    public ShoeController(ShoeService shoeService) {
        this.shoeService = shoeService;
    }

    @PostMapping(value = "/add_deck/{deckID}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public String addDeckToShoe(@PathVariable Long gameID, @PathVariable Long deckID) throws Exception {
        shoeService.addDeckToShoe(gameID, deckID);
        return "OK";
    }

    @PostMapping(value = "/deal/{playerID}", produces = "application/json")
    public ShoeCard dealToPlayer(@PathVariable Long gameID, @PathVariable Long playerID) throws Exception {
        ShoeCard card = shoeService.dealToPlayer(gameID, playerID);
        return card;
    }

    @PostMapping(value = "/shuffle", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public String shuffleShoe(@PathVariable Long gameID){
        return "";
    }
}
