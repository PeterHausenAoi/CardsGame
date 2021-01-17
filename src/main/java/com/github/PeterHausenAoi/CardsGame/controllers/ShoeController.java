package com.github.PeterHausenAoi.CardsGame.controllers;

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
    @ResponseStatus(HttpStatus.OK)
    public String dealToPlayer(@PathVariable Long gameID, @PathVariable Long playerID){
        return "";
    }

    @PostMapping(value = "/shuffle", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public String shuffleShoe(@PathVariable Long gameID){
        return "";
    }
}
