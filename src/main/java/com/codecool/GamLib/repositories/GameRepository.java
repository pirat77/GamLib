package com.codecool.GamLib.repositories;

import com.codecool.GamLib.model.Game;
import com.codecool.GamLib.model.Genre;
import com.codecool.GamLib.model.Studio;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GameRepository extends CrudRepository<Game, Long> {

    @Override
    Optional<Game> findById(Long id);
    List<Game> findByTitle(String title);
    List<Game> findByGenre(Genre genre);
}
