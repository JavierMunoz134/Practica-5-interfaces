package com.example.coffee_shop;


public class DataModel {
    private int imageResource;
    private String title;
    private String location;
    private float rating;

    public DataModel(int imageResource, String title, String location, float rating) {
        this.imageResource = imageResource;
        this.title = title;
        this.location = location;
        this.rating = rating;
    }

    public int getImageResource() {
        return imageResource;
    }

    public String getTitle() {
        return title;
    }

    public String getLocation() {
        return location;
    }

    public float getRating() {
        return rating;
    }
}
