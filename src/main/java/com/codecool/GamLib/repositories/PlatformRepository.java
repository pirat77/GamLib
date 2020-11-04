package com.codecool.GamLib.repositories;

import com.codecool.GamLib.model.Platform;
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;
import org.springframework.lang.NonNullApi;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlatformRepository extends CrudRepository<Platform, Long> {

    @Override
    @NonNull
    List<Platform> findAll();
}
