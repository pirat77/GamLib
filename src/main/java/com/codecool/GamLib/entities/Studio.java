package com.codecool.GamLib.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Studio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name = "found_date")
    private Date foundDate;
    private String country;
    @Column(name = "studio_logo")
    private String studioLogo;

    @OneToMany(mappedBy = "studio", fetch = FetchType.LAZY)
    private List<Game> game;

    public Studio(String name, Date foundDate, String country, String studioLogo, List<Game> game) {
        this.name = name;
        this.foundDate = foundDate;
        this.country = country;
        this.studioLogo = studioLogo;
        this.game = game;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getFoundDate() {
        return foundDate;
    }

    public String getCountry() {
        return country;
    }

    public String getStudioLogo() {
        return studioLogo;
    }

    public List<Game> getGame() {
        return game;
    }
}