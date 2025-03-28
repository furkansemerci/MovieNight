package com.fes.movienight.models;

import org.springframework.data.mongodb.core.mapping.Document;
import com.fes.movienight.models.Imdb;


import java.util.Arrays;

@Document(collection = "movies")
public class PostModel {
    private String id;
    private String title;
    private String plot;
    private String cast[];
    private String genres[];
    private int ReleaseYear;
    private Imdb imdb;
    private String languages[];
    private String directors[];
    private String actors[];
    private String ageRating;

    public PostModel() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String[] getCast() {
        return cast;
    }

    public void setCast(String[] cast) {
        this.cast = cast;
    }

    public String[] getGenres() {
        return genres;
    }

    public void setGenres(String[] genres) {
        this.genres = genres;
    }

    public int getReleaseYear() {
        return ReleaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        ReleaseYear = releaseYear;
    }

    public Imdb getImdb() {
        return imdb;
    }

    public void setImdb(Imdb imdb) {
        this.imdb = imdb;
    }

    public String[] getLanguages() {
        return languages;
    }

    public void setLanguages(String[] languages) {
        this.languages = languages;
    }

    public String[] getDirectors() {
        return directors;
    }

    public void setDirectors(String[] directors) {
        this.directors = directors;
    }

    public String[] getActors() {
        return actors;
    }

    public void setActors(String[] actors) {
        this.actors = actors;
    }

    public String getAgeRating() {
        return ageRating;
    }

    public void setAgeRating(String ageRating) {
        this.ageRating = ageRating;
    }

    @Override
    public String toString() {
        return "PostModel{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", plot='" + plot + '\'' +
                ", cast=" + cast +
                ", genres=" + genres +
                ", ReleaseYear=" + ReleaseYear +
                ", imdb=" + imdb +
                ", languages=" + languages +
                ", directors=" + directors +
                ", actors=" + actors +
                ", ageRating='" + ageRating + '\'' +
                '}';
    }
}
