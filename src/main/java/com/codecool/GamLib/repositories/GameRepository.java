package com.codecool.GamLib.repositories;

import org.springframework.data.repository.core.CrudMethods;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Method;
import java.util.Optional;

@Repository
public class GameRepository implements CrudMethods {
    public GameRepository(){}

    @Override
    public Optional<Method> getSaveMethod() {
        return Optional.empty();
    }

    @Override
    public boolean hasSaveMethod() {
        return true;
    }

    @Override
    public Optional<Method> getFindAllMethod() {
        return Optional.empty();
    }

    @Override
    public boolean hasFindAllMethod() {
        return true;
    }

    @Override
    public Optional<Method> getFindOneMethod() {
        return Optional.empty();
    }

    @Override
    public boolean hasFindOneMethod() {
        return true;
    }

    @Override
    public Optional<Method> getDeleteMethod() {
        return Optional.empty();
    }

    @Override
    public boolean hasDelete() {
        return true;
    }
}
