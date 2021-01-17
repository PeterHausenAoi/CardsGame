package com.github.PeterHausenAoi.CardsGame.repositories;

import com.github.PeterHausenAoi.CardsGame.models.CardSuit;
import com.github.PeterHausenAoi.CardsGame.models.messages.UndealtCardMeta;
import com.github.PeterHausenAoi.CardsGame.models.messages.UndealtSuitMeta;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CardSuitRepository extends CrudRepository<CardSuit, Long> {
    @Query(value = "select\n" +
            "\tcs2.\"name\" as suit, \n" +
            "\tcoalesce(meta.count, 0) as count\n" +
            "from\n" +
            "\tcard_suits cs2 \n" +
            "\tleft join(\n" +
            "\t\tselect \n" +
            "\t\t\tcs.id, \n" +
            "\t\t\tcount(*) as count\n" +
            "\t\tfrom \n" +
            "\t\t\tshoe_cards sc\n" +
            "\t\t\tjoin shoe_decks sd on(sc.shoe_deck_id = sd.id)\n" +
            "\t\t\tjoin shoes s on(sd.shoe_id = s.id)\n" +
            "\t\t\tjoin deck_cards dc on(sc.deck_card_id = dc.id)\n" +
            "\t\t\tjoin card_suits cs on(dc.card_suit_id = cs.id)\n" +
            "\t\t\tjoin card_values cv on(dc.card_value_id = cv.id)\n" +
            "\t\twhere\n" +
            "\t\t\ts.game_id = :gameID\n" +
            "\t\t\tand sc.discarded = false\n" +
            "\t\t\tand sc.player_id is null\n" +
            "\t\tgroup by\n" +
            "\t\t\tcs.id,\n" +
            "\t\t\tcs.name\n" +
            "\t)meta on (cs2.id = meta.id)", nativeQuery = true)
    List<UndealtSuitMeta> getUndealtSuitMeta(@Param("gameID") Long gameID);

    @Query(value = "select\n" +
            "\tcs.\"name\" as suit,\n" +
            "\tcv.\"name\" as value,\n" +
            "\tcv.value as numvalue,\n" +
            "\tcoalesce(meta.count, 0) as count\n" +
            "from\n" +
            "\tcard_suits cs\n" +
            "\tjoin card_values cv on(cs.id > 0)\n" +
            "\tleft join(\n" +
            "\t\tselect\n" +
            "\t\t\tcs.id as cs_id, \n" +
            "\t\t\tcv.id as cv_id, \n" +
            "\t\t\tcount(*) as count\n" +
            "\t\tfrom \n" +
            "\t\t\tshoe_cards sc\n" +
            "\t\t\tjoin shoe_decks sd on(sc.shoe_deck_id = sd.id)\n" +
            "\t\t\tjoin shoes s on(sd.shoe_id = s.id)\n" +
            "\t\t\tjoin deck_cards dc on(sc.deck_card_id = dc.id)\n" +
            "\t\t\tjoin card_suits cs on(dc.card_suit_id = cs.id)\n" +
            "\t\t\tjoin card_values cv on(dc.card_value_id = cv.id)\n" +
            "\t\twhere\n" +
            "\t\t\ts.game_id = :gameID\n" +
            "\t\t\tand sc.discarded = false\n" +
            "\t\t\tand sc.player_id is null\n" +
            "\t\tgroup by\n" +
            "\t\t\tcs.id,\n" +
            "\t\t\tcs.name,\n" +
            "\t\t\tcv.id,\n" +
            "\t\t\tcv.\"name\"\n" +
            "\t)meta on(meta.cs_id = cs.id and meta.cv_id = cv.id)\n" +
            "order by\n" +
            "\tcs.ordinal_position,\n" +
            "\tcv.value desc", nativeQuery = true)
    List<UndealtCardMeta> getUndealtCardMeta(@Param("gameID") Long gameID);
}
