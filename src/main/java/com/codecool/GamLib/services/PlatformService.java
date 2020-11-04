package com.codecool.GamLib.services;

import com.codecool.GamLib.model.Platform;
import com.codecool.GamLib.repositories.PlatformRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlatformService {

    @Autowired
    private static PlatformRepository platformRepository;

    public String getALL(){
        String output = "";
        List<Platform> allPlatforms = platformRepository.findAll();
        //todo create string from allPlatforms"
        return output;
    }

    public String getById(long id) {
        Optional<Platform> optionalPlatform = platformRepository.findById(id);
        if (optionalPlatform.isEmpty()) return "{}";
        else return optionalPlatform.get().JSONrepresentation();
    }

    public Optional<Platform> add(String platformJson) {
        Optional<Platform> optionalPlatform = Platform.buildFromJson(platformJson);
        if (optionalPlatform.isEmpty()) return optionalPlatform;
        return Optional.of(platformRepository.save(optionalPlatform.get()));
    }

    public long deleteAll() {
        platformRepository.deleteAll();
        return platformRepository.count();
    }

    public long deleteById(long id) {
        platformRepository.deleteById(id);
        return platformRepository.count();
    }

    public long replaceAll(String jsonPlatformCollection) {
        deleteAll();
        //todo get platforms from json and save them
        return platformRepository.count();
    }

    public long replaceById(long id, String json) {
        Optional<Platform> optionalPlatform = Platform.buildFromJson(json);
        if (optionalPlatform.isEmpty()) return -1L;
        Platform platform = optionalPlatform.get();
        platform.setId(id);
        platformRepository.save(platform);
        return platformRepository.count();
    }


}
