package com.github.PeterHausenAoi.CardsGame.repositories;

import com.github.PeterHausenAoi.CardsGame.models.CardSuit;
import com.github.PeterHausenAoi.CardsGame.models.messages.UndealtCardMeta;
import com.github.PeterHausenAoi.CardsGame.models.messages.UndealtSuitMeta;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CardSuitRepository extends CrudRepository<CardSuit, Long> {
    @Query(value = "select \n" +
            "\tcs.name as suit,\n" +
            "\tcount(*) as count\n" +
            "from \n" +
            "\tshoe_cards sc\n" +
            "\tjoin shoe_decks sd on(sc.shoe_deck_id = sd.id)\n" +
            "\tjoin shoes s on(sd.shoe_id = s.id)\n" +
            "\tjoin deck_cards dc on(sc.deck_card_id = dc.id)\n" +
            "\tjoin card_suits cs on(dc.card_suit_id = cs.id)\n" +
            "where\n" +
            "\ts.game_id = :gameID\n" +
            "\tand sc.discarded = false\n" +
            "\tand sc.player_id is null\n" +
            "group by\n" +
            "\tcs.id,\n" +
            "\tcs.name", nativeQuery = true)
    List<UndealtSuitMeta> getUndealtSuitMeta(@Param("gameID") Long gameID);

    @Query(value = "select \n" +
            "\tcs.name as suit,\n" +
            "\tcv.\"name\" as value,\n" +
            "\tcv.value as numvalue,\n" +
            "\tcount(*) as count\n" +
            "from \n" +
            "\tshoe_cards sc\n" +
            "\tjoin shoe_decks sd on(sc.shoe_deck_id = sd.id)\n" +
            "\tjoin shoes s on(sd.shoe_id = s.id)\n" +
            "\tjoin deck_cards dc on(sc.deck_card_id = dc.id)\n" +
            "\tjoin card_suits cs on(dc.card_suit_id = cs.id)\n" +
            "\tjoin card_values cv on(dc.card_value_id = cv.id)\n" +
            "where\n" +
            "\ts.game_id = :gameID\n" +
            "\tand sc.discarded = false\n" +
            "\tand sc.player_id is null\n" +
            "group by\n" +
            "\tcs.id,\n" +
            "\tcs.name,\n" +
            "\tcv.id,\n" +
            "\tcv.\"name\"\n" +
            "order by\n" +
            "\tcs.ordinal_position,\n" +
            "\tcv.value desc", nativeQuery = true)
    List<UndealtCardMeta> getUndealtCardMeta(@Param("gameID") Long gameID);
}
