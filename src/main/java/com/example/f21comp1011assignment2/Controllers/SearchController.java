package com.example.f21comp1011assignment2.Controllers;

import com.example.f21comp1011assignment2.Models.Hero;
import com.example.f21comp1011assignment2.Utilities.ReadAPI;
import com.example.f21comp1011assignment2.Utilities.SceneChanger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

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
    private TableColumn<Hero, String> nameCol;

    @FXML
    private TableView<Hero> tableView;

    @FXML
    private Label instructionsLabel;

    @FXML
    private TextField searchTextField;

    ArrayList<Hero> allHeroes;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            allHeroes = ReadAPI.getHeroes();
        } catch (IOException e) {
            e.printStackTrace();
        }
        nameCol.setCellValueFactory(new PropertyValueFactory<>("heroName"));

    }

    @FXML
    private void searchButton(ActionEvent event) throws IOException {
        tableView.getItems().clear();
        tableView.getItems().addAll(allHeroes.stream()
                .filter(hero -> hero.contains(searchTextField.getText()))
                .collect(Collectors.toList()));
        tableView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        tableView.getSelectionModel().selectedItemProperty().addListener(
                (obs,oldValue,heroSelected) ->{
                    if(heroSelected != null)
                    {
                        try {
                            SceneChanger.changeScenes(event,"details-view.fxml", heroSelected.getHeroName());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
        );
    }

}