package com.codecool.GamLib.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.persistence.*;
import java.util.List;
import java.util.Optional;

@JsonIgnoreProperties(ignoreUnknown = true, value = {"games"})
@Entity
public class Platform extends GamLibModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name = "cpu_name")
    private String cpuName;
    @Column(name = "cpu_clock_speed")
    private Float cpuClockSpeed;
    private float memory;
    @Column(name = "internal_storage")
    private float internalStorage;
    @Column(name = "platform_logo")
    private String platformLogo;

    @ManyToMany
    private List<Game> games;

    public Platform(){
        super();
    }

    public Platform(String name, String cpuName, Float cpuClockSpeed, float memory,
                    float internalStorage, String platformLogo, List<Game> games) {
        this.name = name;
        this.cpuName = cpuName;
        this.cpuClockSpeed = cpuClockSpeed;
        this.memory = memory;
        this.internalStorage = internalStorage;
        this.platformLogo = platformLogo;
        this.games = games;
    }

    public static Optional<Platform> buildFromJson(String json) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return Optional.of(mapper.readValue(json, Platform.class));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCpuName() {
        return cpuName;
    }

    public Float getCpuClockSpeed() {
        return cpuClockSpeed;
    }

    public float getMemory() {
        return memory;
    }

    public float getInternalStorage() {
        return internalStorage;
    }

    public String getPlatformLogo() {
        return platformLogo;
    }

    public List<Game> getGames() {
        return games;
    }
}
