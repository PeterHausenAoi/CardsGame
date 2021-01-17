#!/bin/bash

docker build -t cards_game_db .
docker run -it --name cards_game_db --rm -p 4999:5432 -e POSTGRES_PASSWORD=pgis -d cards_game_db