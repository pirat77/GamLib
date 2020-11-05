package com.codecool.GamLib.services;

import com.codecool.GamLib.model.GamLibModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class GamLibService<T extends GamLibModel, S extends CrudRepository<T, Long>> {

    @Autowired
    private JsonMapper jsonMapper;
    private Class<T> tClass;
    private S repository;

    public GamLibService() {}

    public GamLibService(Class<T> tClass, S repository) {
        this.tClass = tClass;
        this.repository = repository;
    }

    public String get(Map<String, String> parameters) {
        String output = "";
        if (parameters.keySet().isEmpty()) output = getAll();
        else output = getAllByParams(parameters);
        return output;
    }

    public Optional<T> add(String jsonElement) {
        Optional<T> optional = jsonMapper.getObjectFromJson(jsonElement, tClass);
        if (optional.isEmpty()) return optional;
        return Optional.of(repository.save(optional.get()));
    }

    public long delete(Map<String, String> parameters) {
        long output = 0;
        if (parameters.keySet().isEmpty()) output = deleteAll();
        else output = deleteAllByParams(parameters);
        return output;
    }

    public long replace(Map<String, String> parameters, String jsonElementsList) {
        long output = 0;
        if (parameters.keySet().isEmpty()) output = replaceAll(jsonElementsList);
        else output = replaceAllByParams(parameters, jsonElementsList);
        return output;
    }

    private String getAll(){
        List<T> allElements = new ArrayList<>();
        Iterable<T> elements = repository.findAll();
        elements.forEach(allElements::add);
        return jsonMapper.jsonRepresentation(elements);
    }

    private String getAllByParams(Map<String, String> parameters) {
        List<T> elements = findCommonElements(parameters);
        return jsonMapper.jsonRepresentation(elements);
    }

    private long deleteAll() {
        repository.deleteAll();
        return repository.count();
    }

    private long deleteAllByParams(Map<String, String> parameters) {
        List<T> elements = findCommonElements(parameters);
        if (elements.isEmpty()) return 0L;
        long before = repository.count();
        repository.deleteAll(elements);
        long after = repository.count();
        if (before - after != elements.size()) return -1L;
        return after;
    }

    private long replaceAll(String jsonElementsList) {
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

    private long replaceAllByParams(Map<String, String> parameters, String jsonElementsList) {
        List<T> newElements = jsonMapper.getListOfObjectsFromJson(jsonElementsList, tClass);
        List<T> foundElements = findCommonElements(parameters);
        if (newElements.isEmpty() || foundElements.isEmpty()) return -1L;

        long before = repository.count();
        repository.deleteAll(foundElements);
        long after = repository.count();
        if (before - after != foundElements.size()) return -1L;

        before = after;
        repository.saveAll(newElements);
        after = repository.count();
        if (after - before != newElements.size()) return -1L;

        return after;
    }

    private <U> List<T> findCommonElements(Map<String, String> parameters) {
        String methodPrefix = "findBy";
        List<Method> findByMethods = Arrays.stream(repository.getClass().getMethods())
                .filter(method -> method.getName().startsWith(methodPrefix))
                .collect(Collectors.toList());
        Set<T> foundElements = new HashSet<>();
        for(Method method : findByMethods) {
            List<T> nextElements = getElementsFromMethod(parameters, methodPrefix, method);
            mergeCommonElements(foundElements, nextElements);
        }
        return new ArrayList<>(foundElements);
    }

    private <U> List<T> getElementsFromMethod(Map<String, String> parameters, String methodPrefix, Method method) {
        System.out.println("im here");
        String paramName = method.getName().substring(methodPrefix.length());
        String paramValue = parameters.get(paramName);
        if (paramValue == null) return Collections.emptyList();
        U parameterValue = castParameterFromGivenClass(paramValue, method);
        if (parameterValue == null) return Collections.emptyList();
        try {
            List<T> resultList = (List<T>) method.invoke(repository, parameterValue);
            return resultList;
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    private <U> U castParameterFromGivenClass(String parameter, Method method) {
        U result;
        try {
            Class<U> object = (Class<U>) method.getParameterTypes()[0];
            result = (U) parameter;
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private void mergeCommonElements(Set<T> foundElements, List<T> nextElements) {
        if (foundElements.size() == 0) {
            foundElements.addAll(nextElements);
            return;
        }
        foundElements.retainAll(nextElements);
    }

}
