package com.codecool.GamLib.controllers;

import com.codecool.GamLib.model.Platform;
import com.codecool.GamLib.repositories.PlatformRepository;
import com.codecool.GamLib.requests.PlatformRequest;
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
        String allElements = service.getAll();
        if (allElements.equals("{}")) return statusService.statusAfterGetElementsNotFound(path);
        return allElements;
    }

    @DeleteMapping(path)
    public String deletePlatform(@RequestBody PlatformRequest request){
        return statusService.statusAfterDeleteAll(path, service.deleteAll());
    }

    @PutMapping(path)
    public String putPlatform(@RequestBody String jsonElementsList){
        return statusService.statusAfterReplaceAll(path, service.replaceAll(jsonElementsList));
    }

    @PostMapping(value = path)
    public String postPlatform(@RequestBody String jsonObject){
        return statusService.statusAfterAdd(path, service.add(jsonObject));
    }
}
