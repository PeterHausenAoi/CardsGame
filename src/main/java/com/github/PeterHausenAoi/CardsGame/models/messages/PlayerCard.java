package com.github.PeterHausenAoi.CardsGame.models.messages;

import java.io.Serializable;

public class PlayerCard implements Serializable {
    private final String suit;
    private final String value;
    private final Integer numValue;

    public PlayerCard(String suit, String value, Integer numValue) {
        this.suit = suit;
        this.value = value;
        this.numValue = numValue;
    }

    public String getSuit() {
        return suit;
    }

    public String getValue() {
        return value;
    }

    public Integer getNumValue() {
        return numValue;
    }
}
