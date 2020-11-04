package com.codecool.GamLib.services;

import com.codecool.GamLib.model.GamLibModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GamLibService<T extends GamLibModel, S extends CrudRepository<T, Long>> {

    private S repository;

    public GamLibService() {}

    public String getALL(){
        String output = "";
        Iterable<T> allElements = repository.findAll();
        //todo create string from allPlatforms"
        return output;
    }

    public String getById(long id) {
        Optional<T> optionalPlatform = repository.findById(id);
        if (optionalPlatform.isEmpty()) return "{}";
        else return "string json"; // todo
    }

    public Optional<T> add(String platformElement) {
        Optional<T> optional = Optional.empty(); // todo get element from jsonElement
        if (optional.isEmpty()) return optional;
        return Optional.of(repository.save(optional.get()));
    }

    public long deleteAll() {
        repository.deleteAll();
        return repository.count();
    }

    public long deleteById(long id) {
        repository.deleteById(id);
        return repository.count();
    }

    public long replaceAll(String jsonPlatformCollection) {
        deleteAll();
        //todo get platforms from json and save them
        return repository.count();
    }

    public long replaceById(long id, String jsonElement) {
        Optional<T> optionalElement = Optional.empty(); //todo get element from jsonElement
        if (optionalElement.isEmpty()) return -1L;
        T element = optionalElement.get();
        element.setId(id);
        repository.save(element);
        return repository.count();
    }

}
