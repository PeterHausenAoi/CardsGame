package com.github.PeterHausenAoi.CardsGame.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "card_suits")
public class CardSuit extends BaseEntity{
    @Column(name = "name")
    private String name;
    @Column(name = "ordinal_position")
    private Integer ordinalPosition;

    public CardSuit() {
    }

    public CardSuit(Long id) {
        super(id);
    }

    public CardSuit(String name, Integer ordinalPosition) {
        super();
        this.name = name;
        this.ordinalPosition = ordinalPosition;
    }

    public CardSuit(Long id, String name, Integer ordinalPosition) {
        super(id);
        this.name = name;
        this.ordinalPosition = ordinalPosition;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getOrdinalPosition() {
        return ordinalPosition;
    }

    public void setOrdinalPosition(Integer ordinalPosition) {
        this.ordinalPosition = ordinalPosition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return !super.equals(o);
    }
}
