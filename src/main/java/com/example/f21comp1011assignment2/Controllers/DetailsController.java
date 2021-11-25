package com.example.f21comp1011assignment2.Controllers;

import com.example.f21comp1011assignment2.Utilities.SceneChanger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import com.example.f21comp1011assignment2.InitializeHero;
import com.example.f21comp1011assignment2.Models.Hero;

import java.io.IOException;

public class DetailsController implements InitializeHero {

    @FXML
    private Label publisherLabel;

    @FXML
    private Label durabilityLabel;

    @FXML
    private Label alignmentLabel;

    @FXML
    private Label speedLabel;

    @FXML
    private Label heroNameLabel;

    @FXML
    private Label strengthLabel;

    @FXML
    private ImageView imageView;

    @FXML
    private Label combatLabel;

    @FXML
    private Label powerLabel;

    @FXML
    private Label intelligenceLabel;

    @FXML
    private Label fullNameLabel;

    @FXML
    void backToSearch(ActionEvent event) throws IOException {
        SceneChanger.changeScenes(event,"search-view.fxml","Hero Search Engine");
    }
    @Override
    public void loadHeroDetails(Hero hero) {
        publisherLabel.setText(hero.getBiography().getPublisher());
        durabilityLabel.setText(hero.getPowerstats().getDurability());
        alignmentLabel.setText(hero.getBiography().getAlignment());
        speedLabel.setText(hero.getPowerstats().getSpeed());
        heroNameLabel.setText(hero.getName());
        strengthLabel.setText(hero.getPowerstats().getStrength());
        imageView.setImage(new Image(hero.getImages().getMd()));
        combatLabel.setText(hero.getPowerstats().getCombat());
        powerLabel.setText(hero.getPowerstats().getPower());
        fullNameLabel.setText(hero.getBiography().getFullName());
        intelligenceLabel.setText(hero.getPowerstats().getIntelligence());
    }
}
