package com.example.f21comp1011assignment2.Utilities;

import com.example.f21comp1011assignment2.InitializeHero;
import com.example.f21comp1011assignment2.Main;
import com.example.f21comp1011assignment2.Models.Hero;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneChanger {
    /**
     * Changes to the search scene
     * @param event
     * @param viewFileName
     * @param title
     * @throws IOException
     */
    public static void changeScenes(ActionEvent event, String viewFileName, String title) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(viewFileName));
        Parent parent = fxmlLoader.load();
        Scene scene = new Scene(parent);
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setTitle(title);
        Image icon = new Image("/heroicon.png");
        stage.getIcons().add(icon);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * changes to the hero details view
     * @param event
     * @param viewFileName
     * @param title
     * @param hero
     * @throws IOException
     */
    public static void changeScenes(ActionEvent event, String viewFileName, String title, Hero hero) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(viewFileName));
        Parent parent = fxmlLoader.load();
        Scene scene = new Scene(parent);
        InitializeHero controller = fxmlLoader.getController();
        controller.loadHeroDetails(hero);
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setTitle(title);
        Image icon = new Image("/heroicon.png");
        stage.getIcons().add(icon);
        stage.setScene(scene);
        stage.show();
    }
}
