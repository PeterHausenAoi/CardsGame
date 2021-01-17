package com.github.PeterHausenAoi.CardsGame.models;

import com.fasterxml.jackson.databind.ser.Serializers;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "games")
public class Game extends BaseEntity {

    public Game() {
    }

    public Game(Long id) {
        super(id);
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
