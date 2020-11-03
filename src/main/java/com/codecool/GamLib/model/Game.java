package com.codecool.GamLib.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true, value = {"games"})
@Entity(name = "game")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "released_date")
    private Date releasedDate;

    @Enumerated
    @Column(name = "genre")
    private Genre genre;

    @Column(name = "game_logo")
    private String gameLogo;

    @Column(name = "rating")
    private float rating;

    @Column(name = "description")
    private String description;

    @ManyToOne
    private Studio studio;

    @ManyToMany
    private List<Platform> platforms;

    public Game(){
        super();
    }

    public Game(String title, Date releasedDate, Genre genre, String gameLogo,
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

    public Genre getGenre() {
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
