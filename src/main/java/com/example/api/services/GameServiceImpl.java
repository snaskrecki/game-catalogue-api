package com.example.api.services;

import com.example.api.models.GameDTO;
import com.example.api.models.Game;
import com.example.api.repositories.GameRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;

    public GameServiceImpl(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public Game getGame(int id) {
        Optional<Game> game = gameRepository.findById(id);
        if (game.isEmpty()) {
            throw new NoSuchElementException("Game not found");
        }
        return game.get();
    }

    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }

    public void add(GameDTO gameDTO) {
        Game game = new Game(
                gameDTO.getName(),
                gameDTO.getDescription(),
                gameDTO.getPrice(),
                gameDTO.getCurrency()
        );
        gameRepository.save(game);
    }

    public void update(int id, GameDTO gameDTO) {
        Optional<Game> gameMaybe = gameRepository.findById(id);
        if (gameMaybe.isEmpty()) {
            throw new NoSuchElementException("Game not found");
        }
        Game game = gameMaybe.get();
        game.setName(gameDTO.getName());
        game.setDescription(gameDTO.getDescription());
        game.setPrice(gameDTO.getPrice());
        game.setCurrency(gameDTO.getCurrency());
        gameRepository.save(game);
    }

    public void delete(int id) {
        gameRepository.deleteById(id);
    }

}
