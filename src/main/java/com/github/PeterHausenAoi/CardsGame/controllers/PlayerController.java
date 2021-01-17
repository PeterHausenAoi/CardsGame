package com.github.PeterHausenAoi.CardsGame.controllers;

import com.github.PeterHausenAoi.CardsGame.services.PlayerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/games/{gameID}/players")
public class PlayerController {
    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

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
