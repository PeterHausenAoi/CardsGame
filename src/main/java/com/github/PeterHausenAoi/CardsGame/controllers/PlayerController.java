package com.github.PeterHausenAoi.CardsGame.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/games/{gameID}/players")
public class PlayerController {

    @PostMapping(value = "/", produces = "application/json")
    public String createPlayer(@PathVariable Long gameID){
        return "";
    }

    @DeleteMapping(value = "/{playerID}", produces = "application/json")
    public String deletePlayer(@PathVariable Long gameID, @PathVariable Long playerID){
        return "";
    }

    @GetMapping(value = "/{playerID}/cards", produces = "application/json")
    public String getPlayerCards(@PathVariable Long gameID, @PathVariable Long playerID){
        return "";
    }

    @GetMapping(value = "/states", produces = "application/json")
    public String getPlayerStates(@PathVariable Long gameID){
        return "";
    }
}
