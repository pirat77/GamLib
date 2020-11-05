package com.codecool.GamLib.controllers;

import com.codecool.GamLib.model.Game;
import com.codecool.GamLib.repositories.GameRepository;
import com.codecool.GamLib.services.GamLibService;
import com.codecool.GamLib.services.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class GameController {

    private final String path = "/game";

    @Autowired
    private GamLibService<Game, GameRepository> service;
    @Autowired
    private StatusService statusService;

    @GetMapping(value = path)
    public String getGame(@RequestParam(required = false) Map<String, String> allParams) {
        String allElements = service.get(allParams);
        if (allElements.equals("{}")) return statusService.statusAfterGetElementsNotFound(path);
        return allElements;
    }

    @DeleteMapping(path)
    public String deleteGame(@RequestParam(required = false) Map<String, String> allParams){
        return statusService.statusAfterDelete(path, service.delete(allParams));
    }


    @PutMapping(path)
    public String putGame(@RequestParam(required = false) Map<String, String> allParams,
                              @RequestBody String jsonElementsList){
        return statusService.statusAfterReplace(path, service.replace(allParams, jsonElementsList));
    }

    @PostMapping(value = path)
    public String postGame(@RequestParam(required = false) Map<String, String> allParams,
                               @RequestBody String jsonObject){
        return statusService.statusAfterAdd(path, service.add(jsonObject));
    }
}
