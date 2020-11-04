package com.codecool.GamLib.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JsonMapper {

    @Autowired
    private ObjectMapper mapper;

    public String jsonRepresentation(Object object) {
        String jsonOutput = "";
        try {
            jsonOutput = mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            jsonOutput = "{}";
        }
        return jsonOutput;
    }

    public String jsonRepresentation(List<Object> objectList){
        if (objectList.isEmpty()) return "{}";
        StringBuilder outputBuilder = new StringBuilder();
        outputBuilder.append("{");
        outputBuilder.append(objectList.get(0).getClass().getName());
        outputBuilder.append("s: [");
        for (Object object: objectList){
            outputBuilder.append(jsonRepresentation(object));
            outputBuilder.append(",");
        }
        outputBuilder.append("]}");
        return outputBuilder.toString();
    }
}
