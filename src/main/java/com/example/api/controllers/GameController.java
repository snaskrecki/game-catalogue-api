package com.example.api.controllers;

import com.example.api.models.GameDTO;
import com.example.api.models.Game;
import com.example.api.services.GameService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/games")
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Game> getGame(@PathVariable Integer id) {
        Game game = gameService.getGame(id);
        return ResponseEntity.ok().body(game);
    }

    @GetMapping("")
    public ResponseEntity<List<Game>> getAllGames() {
        List<Game> games = gameService.getAllGames();
        return ResponseEntity.ok().body(games);
    }

    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void addGame(@RequestBody GameDTO game) {
        gameService.add(game);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void updateGame(@PathVariable Integer id, @RequestBody GameDTO game) {
        gameService.update(id, game);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void deleteGame(@PathVariable Integer id) {
        gameService.delete(id);
    }
}
