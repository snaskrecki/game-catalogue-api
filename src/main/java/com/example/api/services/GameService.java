package com.example.api.services;

import com.example.api.models.Game;
import com.example.api.models.GameDTO;

import java.util.List;

public interface GameService {
    Game getGame(int id);
    List<Game> getAllGames();
    void add(GameDTO game);
    void update(int id, GameDTO game);
    void delete(int id);
}
