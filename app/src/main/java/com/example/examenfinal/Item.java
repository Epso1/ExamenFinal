package com.example.examenfinal;

import java.io.Serializable;

public class Item implements Serializable {
    private String name;
    private int cost;
    private String category;
    private String efecto;
    private String imageUrl;

    public Item(String name, int cost, String category, String efecto, String imageUrl) {
        this.name = name;
        this.cost = cost;
        this.category = category;
        this.efecto = efecto;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    public String getCategory() {
        return category;
    }

    public String getEfecto() {
        return efecto;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}