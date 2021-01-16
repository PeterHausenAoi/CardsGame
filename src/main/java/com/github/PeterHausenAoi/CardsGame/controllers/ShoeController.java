package com.github.PeterHausenAoi.CardsGame.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/games/{gameID}/shoes")
public class ShoeController {

    @PostMapping(value = "/add_deck", produces = "application/json")
    public String addDeckToShoe(@PathVariable Long gameID){
        return "";
    }

    @PostMapping(value = "/deal/{playerID}", produces = "application/json")
    public String dealToPlayer(@PathVariable Long gameID, @PathVariable Long playerID){
        return "";
    }

    @PostMapping(value = "/shuffle", produces = "application/json")
    public String shuffleShoe(@PathVariable Long gameID){
        return "";
    }
}
