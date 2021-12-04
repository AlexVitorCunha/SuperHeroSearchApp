package com.example.f21comp1011assignment2.Controllers;

import com.example.f21comp1011assignment2.Models.Hero;
import com.example.f21comp1011assignment2.Utilities.ReadAPI;
import com.example.f21comp1011assignment2.Utilities.SceneChanger;
import com.mashape.unirest.http.exceptions.UnirestException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class SearchController implements Initializable {

    @FXML
    private Label heroesReturnedLabel;

    @FXML
    private ListView<Hero> initialHeroDataListView;

    @FXML
    private ImageView photoImageView;

    @FXML
    private TextField searchTextField;

    @FXML
    private Label errMsgLabel;

    @FXML
    private Button moreDetailsBtn;

    @FXML
    private ImageView errImage;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setHeroFound(false,false);
        errMsgLabel.setVisible(false);
        errImage.setVisible(false);
        initialHeroDataListView.getSelectionModel().selectedItemProperty().addListener(
                (obs,oldHero,heroSelected) ->{
                    try{
                        photoImageView.setImage(new Image(heroSelected.getImages().getMd()));
                        setHeroFound(true,true);
                    }catch (Exception e){

                    }
                });
    }

    @FXML
    private void searchButton(ActionEvent event) throws IOException, UnirestException {
        initialHeroDataListView.getItems().clear();
        Hero[] heroes = ReadAPI.getHeroes(searchTextField.getText());
        try{
            if(heroes.length > 0)
            {
                for(int i = 0; i < heroes.length; i++){
                    initialHeroDataListView.getItems().add(heroes[i]);
                }
                setHeroFound(true,false);
                heroesReturnedLabel.setText("Superheroes found: " + heroes.length);
            }
            else
                setHeroFound(false,false);
        }catch (Exception e){
            setHeroFound(false,false);
            heroesReturnedLabel.setText("Superheroes found: 0");
        }

    }

    private void setHeroFound(boolean heroFound, boolean heroSelected){
        initialHeroDataListView.setVisible(heroFound);
        moreDetailsBtn.setVisible(heroSelected);
        photoImageView.setVisible(heroSelected);
        errMsgLabel.setVisible(!heroFound);
        errImage.setVisible(!heroFound);
    }

    @FXML
    private void getHeroDetails(ActionEvent event) throws IOException {
        Hero hero = initialHeroDataListView.getSelectionModel().getSelectedItem();
        SceneChanger.changeScenes(event,"details-view.fxml",hero.getName(),hero);
    }

}