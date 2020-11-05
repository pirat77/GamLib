package com.codecool.GamLib.repositories;

import com.codecool.GamLib.model.Game;
import com.codecool.GamLib.model.Genre;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends CrudRepository<Game, Long> {



    List<Game> findByStudio(String studio);
    List<Game> findByTitle(String title);
    List<Game> findByGenre(Genre genre);

}
