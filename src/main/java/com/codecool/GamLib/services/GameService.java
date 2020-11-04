package com.codecool.GamLib.services;

import com.codecool.GamLib.model.Game;
import com.codecool.GamLib.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    @Autowired
    private JsonMapper jsonMapper;

    @Autowired
    private GameRepository gameRepository;

    public String getALLResponse(){
        return jsonMapper.jsonRepresentation(gameRepository.findAll());
    }
}
