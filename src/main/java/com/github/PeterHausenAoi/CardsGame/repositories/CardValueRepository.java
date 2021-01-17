package com.github.PeterHausenAoi.CardsGame.repositories;

import com.github.PeterHausenAoi.CardsGame.models.entities.CardValue;
import org.springframework.data.repository.CrudRepository;

public interface CardValueRepository extends CrudRepository<CardValue, Long> {
}
