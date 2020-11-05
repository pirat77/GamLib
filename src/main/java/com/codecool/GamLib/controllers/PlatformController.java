package com.codecool.GamLib.controllers;

import com.codecool.GamLib.model.Platform;
import com.codecool.GamLib.repositories.PlatformRepository;
import com.codecool.GamLib.services.GamLibService;
import com.codecool.GamLib.services.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class PlatformController {

    private final String path = "/platform";

    @Autowired
    private GamLibService<Platform, PlatformRepository> service;
    @Autowired
    private StatusService statusService;

    @GetMapping(value = path)
    public String getPlatform(@RequestParam(required = false) Map<String, String> allParams){
        String allElements = service.get(allParams);
        if (allElements.equals("{}")) return statusService.statusAfterGetElementsNotFound(path);
        return allElements;
    }

    @DeleteMapping(path)
    public String deletePlatform(@RequestParam(required = false) Map<String, String> allParams){
        return statusService.statusAfterDelete(path, service.delete(allParams));
    }

    @PutMapping(path)
    public String putPlatform(@RequestParam(required = false) Map<String, String> allParams,
                              @RequestBody String jsonElementsList){
        return statusService.statusAfterReplace(path, service.replace(allParams, jsonElementsList));
    }

    @PostMapping(value = path)
    public String postPlatform(@RequestParam(required = false) Map<String, String> allParams,
                               @RequestBody String jsonObject){
        return statusService.statusAfterAdd(path, service.add(jsonObject));
    }
}
