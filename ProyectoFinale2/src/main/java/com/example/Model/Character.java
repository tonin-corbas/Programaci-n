package com.example.model;

public class Character {
    private int id;
    private String name;
    private String surname;
    private String brotherhood;
    private int gameId;
    private double rating;

    public Character(int id, String name, String surname, String brotherhood, int gameId, double rating) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.brotherhood = brotherhood;
        this.gameId = gameId;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getBrotherhood() {
        return brotherhood;
    }

    public void setBrotherhood(String brotherhood) {
        this.brotherhood = brotherhood;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
