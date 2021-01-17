package com.github.PeterHausenAoi.CardsGame.controllers;

import com.github.PeterHausenAoi.CardsGame.models.messages.UndealtCardMeta;
import com.github.PeterHausenAoi.CardsGame.models.messages.UndealtSuitMeta;
import com.github.PeterHausenAoi.CardsGame.services.SuitService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/games/{gameID}/suits")
public class SuitController {
    private final SuitService suitService;

    public SuitController(SuitService suitService) {
        this.suitService = suitService;
    }

    @GetMapping(value = "/undealt_suit_meta", produces = "application/json")
    public List<UndealtSuitMeta> getUndealtSuitMeta(@PathVariable Long gameID) throws Exception {
        return suitService.getUndealtSuitMeta(gameID);
    }

    @GetMapping(value = "/undealt_card_meta", produces = "application/json")
    public List<UndealtCardMeta> getUndealtCardMeta(@PathVariable Long gameID) throws Exception {
        return suitService.getUndealtCardMeta(gameID);
    }
}
