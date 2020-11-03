package com.codecool.GamLib.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true, value = {"games"})
@Entity
public class Platform {

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
