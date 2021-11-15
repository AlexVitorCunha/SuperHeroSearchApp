package com.example.f21comp1011assignment2.Models;

import java.util.HashMap;

public class Hero {
    private String heroName, FullName, PlaceOfBirth, Publisher, Image;
    private int Intelligence, Strength, Speed, Durability, Power, Combat;

    public Hero(String heroName) {
        this.heroName = heroName;
    }

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public boolean contains(String searchText){
        searchText = searchText.toLowerCase();
        return heroName.toLowerCase().contains(searchText);
    }
}
