package com.example.f21comp1011assignment2.Models;

public class Hero {
    private Biography items;
    private Powerstats stats;
    private Image photo;

    public Biography getItems() {
        return items;
    }

    public void setItems(Biography items) {
        this.items = items;
    }

    public String toString(){return String.format("%s",items.getFullName());}

    public Powerstats getStats() {
        return stats;
    }

    public void setStats(Powerstats stats) {
        this.stats = stats;
    }

    public Image getPhoto() {
        return photo;
    }

    public void setPhoto(Image photo) {
        this.photo = photo;
    }
}
