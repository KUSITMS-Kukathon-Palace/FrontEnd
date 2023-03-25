package com.example.palace;

public class HomeItem {
    String place;
    Integer image;
    String space;
    String category;
    Integer max;

    public HomeItem(String place, Integer image, String space, String category, Integer max) {
        this.place = place;
        this.image = image;
        this.space = space;
        this.category = category;
        this.max = max;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }

    public String getSpace() {
        return space;
    }

    public void setSpace(String space) {
        this.space = space;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }
}
