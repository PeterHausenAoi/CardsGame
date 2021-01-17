package com.github.PeterHausenAoi.CardsGame.controllers;

import com.github.PeterHausenAoi.CardsGame.models.entities.Game;
import com.github.PeterHausenAoi.CardsGame.models.exceptions.NotFoundException;
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

    /**
     * Creates game
     */
    @PostMapping(value = "/", produces = "application/json")
    public Game createGame(){
        Game game = new Game();
        gameService.save(game);

        return game;
    }

    /**
     * Deletes game
     */
    @DeleteMapping(value = "/{gameID}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public String deleteGame(@PathVariable Long gameID) throws NotFoundException {
        gameService.delete(gameID);
        return "OK";
    }
}
