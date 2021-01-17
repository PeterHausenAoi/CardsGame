package com.github.PeterHausenAoi.CardsGame.controllers;

import com.github.PeterHausenAoi.CardsGame.models.Game;
import com.github.PeterHausenAoi.CardsGame.services.GameService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/games")
public class GameController {
    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping(value = "/", produces = "application/json")
    public Game createGame(){
        Game game = new Game();
        gameService.save(game);

        return game;
    }

    @DeleteMapping(value = "/{gameID}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public String deleteGame(@PathVariable Long gameID) throws Exception {
        gameService.delete(gameID);
        return "OK";
    }
}
