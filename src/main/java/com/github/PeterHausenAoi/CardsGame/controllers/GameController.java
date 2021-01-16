package com.github.PeterHausenAoi.CardsGame.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/games")
public class GameController {

    @PostMapping(value = "/", produces = "application/json")
    public String createGame(){
        // TODO return new game POJO
        return "";
    }

    @DeleteMapping(value = "/{gameID}", produces = "application/json")
    public String deleteGame(@PathVariable Long gameID){
        // TODO return new game POJO
        return "";
    }
}
