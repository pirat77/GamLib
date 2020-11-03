package com.codecool.GamLib.controllers;

import com.codecool.GamLib.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class GameController {

    @Autowired
    private static GameService gameService;

    @GetMapping(value = "/Game")
    public String getGame(@RequestBody GameRequest request){
        return gameService.getALLResponse();
    }

    @DeleteMapping("/Game")
    public String deleteGame(@RequestBody GameRequest request){
        String output = "";

        return output;
    }

    @PutMapping("/Game")
    public String putGame(@RequestBody GameRequest request){
        String output = "";

        return output;
    }

    @PostMapping(value = "/Game")
    public String postGame(@RequestBody GameRequest request){
        String output = "";

        return output;
    }
}
