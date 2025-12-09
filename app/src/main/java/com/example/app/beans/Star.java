package com.example.app.beans;

public class Star {
    private int id;
    private String name;
    private float rating;
    private int imageResId;
    private String imageAssetName; // Nom du fichier dans assets (ex: "leonardo.png")

    public Star() {
        this.imageResId = 0;
        this.imageAssetName = null;
    }

    public Star(int id, String name, float rating) {
        this.id = id;
        this.name = name;
        this.rating = rating;
        this.imageAssetName = null;
    }

    public Star(int id, String name, float rating, int imageResId) {
        this.id = id;
        this.name = name;
        this.rating = rating;
        this.imageResId = imageResId;
        this.imageAssetName = null;
    }

    public Star(int id, String name, float rating, int imageResId, String imageAssetName) {
        this.id = id;
        this.name = name;
        this.rating = rating;
        this.imageResId = imageResId;
        this.imageAssetName = imageAssetName;
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

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public int getImageResId() {
        return imageResId;
    }

    public void setImageResId(int imageResId) {
        this.imageResId = imageResId;
    }

    public String getImageAssetName() {
        return imageAssetName;
    }

    public void setImageAssetName(String imageAssetName) {
        this.imageAssetName = imageAssetName;
    }

    @Override
    public String toString() {
        return "Star{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", rating=" + rating +
                '}';
    }
}

