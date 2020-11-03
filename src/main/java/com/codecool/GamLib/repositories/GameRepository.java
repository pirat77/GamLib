package com.codecool.GamLib.repositories;

import com.codecool.GamLib.model.Game;
import com.codecool.GamLib.model.Genre;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface GameRepository extends CrudRepository<Game, Long> {

    //Game findByGenreAndCost(Genre genre, int cost);

}
