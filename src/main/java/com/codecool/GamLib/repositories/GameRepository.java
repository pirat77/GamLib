package com.codecool.GamLib.repositories;

import com.codecool.GamLib.model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;


@Repository
public class GameRepository {
    @Autowired
    private static EntityManager entityManager;

    public GameRepository(){}

    public List<Game> findAll(){
        return entityManager.createNamedQuery("Game.getAll", Game.class).getResultList();
    }

}
