package com.codecool.GamLib.controllers;

import com.codecool.GamLib.model.Studio;
import com.codecool.GamLib.repositories.StudioRepository;
import com.codecool.GamLib.services.GamLibService;
import com.codecool.GamLib.services.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class StudioController {

    private final String path = "/studio";

    @Autowired
    private GamLibService<Studio, StudioRepository> service;
    @Autowired
    private StatusService statusService;

    @GetMapping(value = path)
    public String getStudio(@RequestParam(required = false) Map<String, String> allParams) {
        String allElements = service.get(allParams);
        if (allElements.equals("{}")) return statusService.statusAfterGetElementsNotFound(path);
        return allElements;
    }

    @DeleteMapping(path)
    public String deleteStudio(@RequestParam(required = false) Map<String, String> allParams){
        return statusService.statusAfterDelete(path, service.delete(allParams));
    }

    @PutMapping(path)
    public String putStudio(@RequestParam(required = false) Map<String, String> allParams,
                          @RequestBody String jsonElementsList){
        return statusService.statusAfterReplace(path, service.replace(allParams, jsonElementsList));
    }

    @PostMapping(value = path)
    public String postStudio(@RequestParam(required = false) Map<String, String> allParams,
                           @RequestBody String jsonObject){
        return statusService.statusAfterAdd(path, service.add(jsonObject));
    }
}

