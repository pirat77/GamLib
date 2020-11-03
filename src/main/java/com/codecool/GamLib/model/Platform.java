package com.codecool.GamLib.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true, value = {"platforms"})
@Entity
public class Platform {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "cpu_name")
    private String cpuName;

    @Column(name = "gpu_name")
    private String gpuName;

    @Column(name = "memory")
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

    public Platform(String name, String cpuName, String gpuName, float memory,
                    float internalStorage, String platformLogo, List<Game> games) {
        this.name = name;
        this.cpuName = cpuName;
        this.gpuName = gpuName;
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

    public String getGpuName() {
        return gpuName;
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
