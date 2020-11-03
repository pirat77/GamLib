package com.codecool.GamLib.repositories;

import com.codecool.GamLib.model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.core.CrudMethods;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Optional;

@Repository
public class GameRepository {
    @Autowired
    private static EntityManager entityManager;

    public GameRepository(){}

    public List<Game> findAll(){
        return entityManager.createNamedQuery("Game.getAll", Game.class).getResultList();
    }

}
