package com.example.el_sol;

// SolarItem.java
public class SolarItem {
    private String name;
    private int imageResource;

    public SolarItem(String name, int imageResource) {
        this.name = name;
        this.imageResource = imageResource;
    }

    public String getName() {
        return name;
    }

    public int getImageResource() {
        return imageResource;
    }
}
