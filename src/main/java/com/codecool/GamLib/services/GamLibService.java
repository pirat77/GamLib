package com.codecool.GamLib.services;

import com.codecool.GamLib.model.GamLibModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GamLibService<T extends GamLibModel, S extends CrudRepository<T, Long>> {

    @Autowired
    private JsonMapper jsonMapper;
    private Class<T> tClass;
    private S repository;

    public GamLibService() {}

    public GamLibService(S repository) {
        this.repository = repository;
    }

    public String getAll(){
        String output = "";
        List<T> allElements = new ArrayList<>();
        Iterable<T> elements = repository.findAll();
        elements.forEach(allElements::add);
        return jsonMapper.jsonRepresentation(elements);
    }

    public String getById(long id) {
        Optional<T> optionalPlatform = repository.findById(id);
        return jsonMapper.jsonRepresentation(optionalPlatform.get());
    }

    public Optional<T> add(String jsonElement) {
        Optional<T> optional = jsonMapper.getObjectFromJson(jsonElement, tClass);
        if (optional.isEmpty()) return optional;
        return Optional.of(repository.save(optional.get()));
    }

    public long deleteAll() {
        repository.deleteAll();
        return repository.count();
    }

    public Long deleteById(long id) {
        if (!repository.existsById(id)) return 0L;
        long before = repository.count();
        repository.deleteById(id);
        long after = repository.count();
        if (before - after != 1L) return -1L;
        return after;
    }

    public long replaceAll(String jsonElementsList) {
        List<T> elements = jsonMapper.getListOfObjectsFromJson(jsonElementsList, tClass);
        if (elements.isEmpty()) return 0L;

        repository.deleteAll();
        long currentNumberOfRows = repository.count();
        if (currentNumberOfRows != 0) return -1;

        repository.saveAll(elements);
        currentNumberOfRows = repository.count();
        if (currentNumberOfRows != elements.size()) return -1L;

        return currentNumberOfRows;
    }

    public long replaceById(long id, String jsonElement) {
        Optional<T> optionalElement = jsonMapper.getObjectFromJson(jsonElement, tClass);
        if (optionalElement.isEmpty()) return -1L;
        T element = optionalElement.get();
        element.setId(id);
        repository.save(element);
        return repository.count();
    }

}
