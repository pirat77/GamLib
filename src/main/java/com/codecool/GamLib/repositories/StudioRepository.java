package com.codecool.GamLib.repositories;

import com.codecool.GamLib.model.Studio;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface StudioRepository extends CrudRepository<Studio, Long> {

    @Override
    Optional<Studio> findById(Long id);
    List<Studio> findByName(String name);
    List<Studio> findByCountry(String country);
}