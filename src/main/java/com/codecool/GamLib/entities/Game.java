package com.codecool.GamLib.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @Column(name = "released_date")
    private Date releasedDate;
    private String genre;
    @Column(name = "game_logo")
    private String gameLogo;
    private float rating;
    private String description;

    @ManyToOne
    private Studio studio;

    @ManyToMany
    private List<Platform> platforms;

    public Game(String title, Date releasedDate, String genre, String gameLogo,
                float rating, String description, Studio studio, List<Platform> platforms) {
        this.title = title;
        this.releasedDate = releasedDate;
        this.genre = genre;
        this.gameLogo = gameLogo;
        this.rating = rating;
        this.description = description;
        this.studio = studio;
        this.platforms = platforms;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Date getReleasedDate() {
        return releasedDate;
    }

    public String getGenre() {
        return genre;
    }

    public String getGameLogo() {
        return gameLogo;
    }

    public float getRating() {
        return rating;
    }

    public String getDescription() {
        return description;
    }

    public Studio getStudio() {
        return studio;
    }

    public List<Platform> getPlatforms() {
        return platforms;
    }
}
