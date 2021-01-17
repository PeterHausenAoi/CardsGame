package com.github.PeterHausenAoi.CardsGame.controllers;

import com.github.PeterHausenAoi.CardsGame.models.entities.Player;
import com.github.PeterHausenAoi.CardsGame.models.exceptions.NotFoundException;
import com.github.PeterHausenAoi.CardsGame.models.messages.PlayerCard;
import com.github.PeterHausenAoi.CardsGame.models.messages.PlayerState;
import com.github.PeterHausenAoi.CardsGame.services.PlayerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/games/{gameID}/players")
public class PlayerController {
    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    /**
     * Adds player to a game
     */
    @PostMapping(value = "/", produces = "application/json")
    public Player createPlayer(@PathVariable Long gameID) throws NotFoundException {
        Player player = new Player();
        playerService.save(player, gameID);
        return player;
    }

    /**
     * Removes player from a game
     */
    @DeleteMapping(value = "/{playerID}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public String deletePlayer(@PathVariable Long gameID, @PathVariable Long playerID) throws NotFoundException {
        playerService.delete(gameID, playerID);
        return "OK";
    }

    /**
     * Get the list of cards for a player
     */
    @GetMapping(value = "/{playerID}/cards", produces = "application/json")
    public List<PlayerCard> getPlayerCards(@PathVariable Long gameID, @PathVariable Long playerID) throws NotFoundException {
        return playerService.getPlayerCards(gameID, playerID);
    }

    /**
     * Get the list of players in a game along with the total added value of all the cards each
     * player holds;
     */
    @GetMapping(value = "/states", produces = "application/json")
    public List<PlayerState> getPlayerStates(@PathVariable Long gameID) throws NotFoundException {
        return playerService.getPlayerStates(gameID);
    }
}
