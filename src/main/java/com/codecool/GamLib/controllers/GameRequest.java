package com.codecool.GamLib.controllers;

import com.codecool.GamLib.model.Genre;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Builder
@Getter
public class GameRequest {
    private final String title;
    private final Date release;
    private final Genre genre;
    private final String game_logo;
    private final float rating;
    private final String description;
}
