package com.github.PeterHausenAoi.CardsGame.repositories;

import com.github.PeterHausenAoi.CardsGame.models.entities.ShoeCard;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ShoeCardRepository extends CrudRepository<ShoeCard, Long> {
    @Query(value = "select \n" +
            "\tsc.*\n" +
            "from \n" +
            "\tshoe_cards sc\n" +
            "\tjoin shoe_decks sd on(sc.shoe_deck_id = sd.id)\n" +
            "\tjoin shoes s on(sd.shoe_id = s.id)\n" +
            "where\n" +
            "\ts.game_id = ?1 \n" +
            "\tand sc.discarded = false\n" +
            "\tand sc.player_id is null\n" +
            "order by\n" +
            "\tsc.ordinal_position limit 1", nativeQuery = true)
    Optional<ShoeCard> getNextCard(@Param("gameID") Long gameID);

    @Modifying
    @Query(value = "update \n" +
                    "\tshoe_cards \n" +
                    "set\n" +
                    "\tplayer_id = null,\n" +
                    "\tdiscarded = true \n" +
                    "where\n" +
                    "\tplayer_id = :playerID", nativeQuery = true)
    void discardPlayerCards(@Param("playerID") Long playerID);
}
