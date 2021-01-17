docker build -t cards_game_app .
docker run --net=host -it --name cards_game_spring_app --rm -p 8080:8080 -d cards_game_app
docker logs cards_game_spring_app -f