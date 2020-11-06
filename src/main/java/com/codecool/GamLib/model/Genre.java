package com.codecool.GamLib.model;

public enum Genre {
    FPS("FPS"),
    RPG("RPG"),
    RTS("RTS"),
    TPP("TPP"),
    ARCADE("ARCADE"),
    RACER("RACER"),
    SPORT("SPORT"),
    FIGHT("FIGHT"),
    ADVENTURE("ADVENTURE"),
    LOGIC("LOGIC");

    private final String name;

    private Genre(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}
