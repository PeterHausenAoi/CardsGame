package com.github.PeterHausenAoi.CardsGame.models.messages;

import java.io.Serializable;

public final class PlayerState implements Serializable {
    private final Long playerID;
    private final Long handValue;

    public PlayerState(Long playerID, Long handValue) {
        this.playerID = playerID;
        this.handValue = handValue;
    }

    public Long getPlayerID() {
        return playerID;
    }

    public Long getHandValue() {
        return handValue;
    }
}
