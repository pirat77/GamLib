package com.codecool.GamLib.controllers;

import com.codecool.GamLib.model.Game;
import com.codecool.GamLib.repositories.GameRepository;
import com.codecool.GamLib.services.GamLibService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class GameController {

    @Autowired
    private GamLibService<Game, GameRepository> service;

    @GetMapping(value = "/game")
    public String getGame(@RequestBody GameRequest request){
        return service.getAll();
    }

    @DeleteMapping("/game")
    public String deleteGame(@RequestBody GameRequest request){
        String output = "";

        return output;
    }

    @PutMapping("/game")
    public String putGame(@RequestBody GameRequest request){
        String output = "";

        return output;
    }

    @PostMapping(value = "/game")
    public String postGame(@RequestBody GameRequest request){
        String output = "";

        return output;
    }
}
