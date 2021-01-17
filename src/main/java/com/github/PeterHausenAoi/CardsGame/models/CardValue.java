package com.github.PeterHausenAoi.CardsGame.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "card_values")
public class CardValue extends BaseEntity {
    @Column(name = "name")
    private String name;
    @Column(name = "value")
    private Integer value;

    public CardValue() {
    }

    public CardValue(Long id) {
        super(id);
    }

    public CardValue(String name, Integer value) {
        this.name = name;
        this.value = value;
    }

    public CardValue(Long id, String name, Integer value) {
        super(id);
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return !super.equals(o);
    }
}
