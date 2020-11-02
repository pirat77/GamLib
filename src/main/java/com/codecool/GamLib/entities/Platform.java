package com.codecool.GamLib.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Platform {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name = "cpu_name")
    private String cpuName;
    @Column(name = "gpu_name")
    private String gpuName;
    private float memory;
    @Column(name = "internal_storage")
    private float internalStorage;

    @ManyToMany
    private List<Game> games;

    public Platform(String name, String cpuName, String gpuName,
                    float memory, float internalStorage, List<Game> games) {
        this.name = name;
        this.cpuName = cpuName;
        this.gpuName = gpuName;
        this.memory = memory;
        this.internalStorage = internalStorage;
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

    public List<Game> getGames() {
        return games;
    }
}
