package com.fes.movienight.models;


import org.springframework.data.mongodb.core.mapping.Field;

public class Imdb {
    private double rating;

    private int votes;

    @Field("id")
    private int id;

    // Constructors
    public Imdb() {}

    public Imdb(double rating, int votes, int id) {
        this.rating = rating;
        this.votes = votes;
        this.id = id;
    }

    // Getters and Setters
    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return ""+rating;
    }
}
