package com.codecool.GamLib.services;

import com.codecool.GamLib.model.Platform;
import com.codecool.GamLib.repositories.PlatformRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlatformService {

    @Autowired
    private static PlatformRepository platformRepository;

    public String getALL(){
        String output = "{\"platforms\": [";
        for (Platform p : platformRepository.findAll()){
            output += (p.jsonRepresentation() + ", ");
        }
        output += "]}";
        return output;
    }

    public String getById(long id) {
        Optional<Platform> optionalPlatform = platformRepository.findById(id);
        if (optionalPlatform.isEmpty()) return "{}";
        else return optionalPlatform.get().jsonRepresentation();
    }

    public void add(String platformJson) {

    }

    public long deleteAll() {
        long numberOfRows = platformRepository.count();
        platformRepository.deleteAll();
        long rowsLeft = platformRepository.count();
        return numberOfRows - rowsLeft;
    }

    public long deleteById(long id) {
        long numberOfRows = platformRepository.count();
        platformRepository.deleteById(id);
        long rowsLeft = platformRepository.count();
        return numberOfRows - rowsLeft;
    }

    public long replaceAll(String jsonPlatformCollection) {
        long affectedRows = deleteAll();
        //todo get platforms from json and save them
        return affectedRows;
    }

    public long replaceById(long id, String json) {
        Optional<Platform> optionalPlatform = Platform.buildFromJson(json);
        if (optionalPlatform.isEmpty()) return 0L;
        Platform platform = optionalPlatform.get();
        platform.setId(id);
        platformRepository.save(platform);
        return 1L;
    }


}
