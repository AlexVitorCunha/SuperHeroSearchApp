package com.example.f21comp1011assignment2.Controllers;

import com.example.f21comp1011assignment2.Models.ApiResponse;
import com.example.f21comp1011assignment2.Models.Hero;
import com.example.f21comp1011assignment2.Utilities.ReadAPI;
import com.example.f21comp1011assignment2.Utilities.SceneChanger;
import com.mashape.unirest.http.exceptions.UnirestException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class SearchController implements Initializable {

    @FXML
    private Label heroesReturnedLabel;

    @FXML
    private ListView<Hero> initialHeroDataListView;

    @FXML
    private ImageView photoImageView;

    @FXML
    private Label instructionsLabel;

    @FXML
    private TextField searchTextField;

    ArrayList<Hero> allHeroes;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initialHeroDataListView.getSelectionModel().selectedItemProperty().addListener(
                (obs,oldHero,heroSelected) ->{
                    try{
                        photoImageView.setImage(new Image(heroSelected.getPhoto().getMd()));
                    }catch (Exception e){

                    }
                });
    }

    @FXML
    private void searchButton(ActionEvent event) throws IOException, UnirestException {
        initialHeroDataListView.getItems().clear();
        Hero[] heroes = ReadAPI.getHeroes(searchTextField.getText());
        if(heroes != null)
        {
            for(int i = 1; i <= heroes.length; i++){
                initialHeroDataListView.getItems().add(heroes[i]);
            }
        }
    }

}