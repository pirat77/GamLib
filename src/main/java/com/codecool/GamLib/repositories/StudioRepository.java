package com.codecool.GamLib.repositories;

import com.codecool.GamLib.model.Studio;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface StudioRepository extends CrudRepository<Studio, Long> {

    List<Studio> findByName(String studio);
    List<Studio> findByCountry(String title);
}