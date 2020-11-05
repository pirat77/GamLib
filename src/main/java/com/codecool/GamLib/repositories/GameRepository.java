package com.codecool.GamLib.repositories;

import com.codecool.GamLib.model.Game;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends CrudRepository<Game, Long> {

    List<Game> findByTitle(String title);
    List<Game> findByGenre(String genre);
    List<Game> findByRating(Float rating);

}
