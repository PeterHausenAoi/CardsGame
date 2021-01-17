package com.github.PeterHausenAoi.CardsGame.services;

import com.github.PeterHausenAoi.CardsGame.models.messages.UndealtCardMeta;
import com.github.PeterHausenAoi.CardsGame.models.messages.UndealtSuitMeta;

import java.util.List;

public interface SuitService {
    List<UndealtSuitMeta> getUndealtSuitMeta(Long gameID) throws Exception;
    List<UndealtCardMeta> getUndealtCardMeta(Long gameID) throws Exception;
}
