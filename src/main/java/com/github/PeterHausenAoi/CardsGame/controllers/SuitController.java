package com.github.PeterHausenAoi.CardsGame.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/games/{gameID}/suits")
public class SuitController {

    @GetMapping(value = "/undealt_suit_meta", produces = "application/json")
    public String getUndealtSuitMeta(@PathVariable Long gameID){
        return "";
    }

    @GetMapping(value = "/undealt_card_meta", produces = "application/json")
    public String getUndealtCardMeta(@PathVariable Long gameID){
        return "";
    }
}
