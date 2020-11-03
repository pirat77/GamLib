package com.codecool.GamLib.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
public class GameController {

    @GetMapping(value = "/Game")
    public String getGame(@RequestBody GameRequest request){
        String output = "";

        return output;
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
