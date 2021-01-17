CREATE TABLE games (
	id int4 NOT NULL GENERATED ALWAYS AS IDENTITY,
	CONSTRAINT games_pkey PRIMARY KEY (id)
);

CREATE TABLE decks (
	id int4 NOT NULL GENERATED ALWAYS AS IDENTITY,
	CONSTRAINT decks_pkey PRIMARY KEY (id)
);

CREATE TABLE deck_cards (
	id int4 NOT NULL GENERATED ALWAYS AS IDENTITY,
    deck_id int4 NOT NULL,
	card_suit_id int4 NOT NULL,
	card_value_id int4 NOT NULL,
	CONSTRAINT deck_cards_pkey PRIMARY KEY (id)
);

CREATE TABLE players (
	id int4 NOT NULL GENERATED ALWAYS AS IDENTITY,
	game_id int4 NOT NULL,
	CONSTRAINT players_pkey PRIMARY KEY (id)
);

CREATE TABLE card_suits (
	id int4 NOT NULL GENERATED ALWAYS AS IDENTITY,
	name varchar NOT NULL,
	ordinal_position int4 not null,
	CONSTRAINT card_suits_pkey PRIMARY KEY (id)
);

CREATE TABLE card_values (
	id int4 NOT NULL GENERATED ALWAYS AS IDENTITY,
	name varchar NOT NULL,
	value int4 not null,
	CONSTRAINT card_values_pkey PRIMARY KEY (id)
);

CREATE TABLE shoes (
	id int4 NOT NULL GENERATED ALWAYS AS IDENTITY,
	game_id int4 NOT NULL,
	CONSTRAINT shoes_pkey PRIMARY KEY (id)
);

CREATE TABLE shoe_decks (
	id int4 NOT NULL GENERATED ALWAYS AS IDENTITY,
	shoe_id int4 NOT NULL,
	deck_id int4 NOT NULL,
	CONSTRAINT shoe_decks_pkey PRIMARY KEY (id)
);

CREATE TABLE shoe_cards (
	id int4 NOT NULL GENERATED ALWAYS AS IDENTITY,
	shoe_deck_id int4 NOT NULL,
	deck_card_id int4 NOT NULL,
	ordinal_position int4 NOT NULL,
	player_id int4 NULL,
	discarded bool default false,
	CONSTRAINT shoe_cards_pkey PRIMARY KEY (id)
);

ALTER TABLE deck_cards ADD CONSTRAINT fk_deck_cards_card_suit_id FOREIGN KEY (card_suit_id) REFERENCES card_suits(id);
ALTER TABLE deck_cards ADD CONSTRAINT fk_deck_cards_card_value_id FOREIGN KEY (card_value_id) REFERENCES card_values(id);
ALTER TABLE deck_cards ADD CONSTRAINT fk_deck_cards_card_deck_id FOREIGN KEY (deck_id) REFERENCES deck_cards(id);

ALTER TABLE players ADD CONSTRAINT fk_players_game_id FOREIGN KEY (game_id) REFERENCES games(id);

ALTER TABLE shoes ADD CONSTRAINT fk_shoes_game_id FOREIGN KEY (game_id) REFERENCES games(id);

ALTER TABLE shoe_decks ADD CONSTRAINT fk_shoes_shoe_id FOREIGN KEY (shoe_id) REFERENCES shoes(id);
ALTER TABLE shoe_decks ADD CONSTRAINT fk_shoe_decks_deck_id FOREIGN KEY (deck_id) REFERENCES decks(id);

ALTER TABLE shoe_cards ADD CONSTRAINT fk_shoe_cards_shoe_deck_id FOREIGN KEY (shoe_deck_id) REFERENCES shoe_decks(id);
ALTER TABLE shoe_cards ADD CONSTRAINT fk_shoe_cards_deck_card_id FOREIGN KEY (deck_card_id) REFERENCES deck_cards(id);
ALTER TABLE shoe_cards ADD CONSTRAINT fk_shoe_cards_player_id FOREIGN KEY (player_id) REFERENCES players(id);

create index deck_cards_card_suit_id_idx on deck_cards(card_suit_id);
create index deck_cards_card_value_id_idx on deck_cards(card_value_id);
create index deck_cards_card_deck_id_idx on deck_cards(deck_id);

create index players_game_id_idx on players(game_id);

create index shoes_card_game_id_idx on shoes(game_id);

create index shoe_decks_shoe_id_idx on shoe_decks(shoe_id);
create index shoe_decks_deck_id_idx on shoe_decks(deck_id);

create index shoe_cards_shoe_deck_id_idx on shoe_cards(shoe_deck_id);
create index shoe_cards_deck_card_id_idx on shoe_cards(deck_card_id);
create index shoe_cards_player_id_idx on shoe_cards(player_id);

