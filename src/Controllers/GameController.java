package Controllers;

import Core.Main;
import Dependencies.pherialize.Pherialize;
import Entities.Game;
import Services.GameService;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.io.IOException;
import java.util.Random;

public class GameController extends PlanetController{

    public GridPane gameList;
    public ImageView image;
    public Label name;
    public VBox listContainer;

    public GameController() {
        this.bgPath = "/assets/images/games-planet.jpg";
        this.roundImagePath = "/assets/images/dice.png";
        this.titleText = "LE MONDE DES JEUX";
        this.subTitleText = "LE MONDE DES JEUX";
        this.enterBtn.setOnAction(e -> openPlanet());
    }

    private void openPlanet(){
        HBox content = null;
        try {
            content = FXMLLoader.load(getClass().getResource("/GUI/game-list.fxml"));
            content.setMaxWidth(Main.scene.getWidth());
            ScrollPane sp2 = (ScrollPane) content.getChildren().get(1);
            ObservableList<Game> games = new GameService().findAll();
            VBox listContainer = (VBox) sp2.getContent();
            gameList =  new GridPane();
            ColumnConstraints cc = new ColumnConstraints();
            cc.setPercentWidth(25);
            gameList.getColumnConstraints().addAll(cc,cc,cc,cc);
            gameList.setHgap(30);
            gameList.setVgap(30);
            gameList.setPrefWidth(Main.scene.getWidth()-350);
            gameList.setPadding(new Insets(10));
            for (int i = 0; i < games.size(); i++) {
                for (int j = 0; j < 4 && i*4+j < games.size(); j++) {
                    Game g = games.get(i*4+j);
                    VBox card = FXMLLoader.load(getClass().getResource("/GUI/game-card.fxml"));
                    Rectangle rect = (Rectangle) card.lookup("#imageHolder");
                    Rectangle overlay = (Rectangle) card.lookup("#overlay");
                    if (g.getIcon() != null) {
                        ImagePattern ip = new ImagePattern(new Image(g.getIcon().getWebPath()));
                        rect.setFill(ip);
                        ImageView noPhoto = (ImageView) card.lookup("#noPhoto");
                        noPhoto.setOpacity(0);
                    }
                    rect.widthProperty().bind(gameList.widthProperty().divide(4).subtract(30));
                    overlay.widthProperty().bind(gameList.widthProperty().divide(4).subtract(30));
                    Label name = (Label) card.lookup("#name");
                    name.setText(g.getName());
                    int finalJ = j;
                    Random random = new Random();
                    card.getStyleClass().add("bg-color-" + (random.nextInt(5)+1));
                    gameList.add(card, j, i);
                    card.setOnMouseClicked(e -> showGame(g));
                }
            }
            listContainer.getChildren().add(gameList);
        } catch (IOException e) {
            e.printStackTrace();
        }
        content.setMaxHeight(Main.scene.getHeight());
        GameController.planet.getChildren().add(content);
    }

//    public void addGame(){
//        List list = new ArrayList<String>();
//        list.add("1");
//        list.add("2");
//        list.add("3");
//        String devs = Pherialize.serialize(list);
//        Game g = new Game(3,"game", "url",1,devs, 1, 2);
//        GameService gs = new GameService();
//
//        gs.addGame(g);
//    }

    public void deleteGame(int id){
        GameService gs = new GameService();
        gs.deleteObject(id, "game");
    }

    public void showGame(Game g) {
        StackPane content = null;
        long start = System.currentTimeMillis();
        try {
            content = FXMLLoader.load(getClass().getResource("/GUI/play-game.fxml"));
            content.setMaxHeight(Main.scene.getHeight());
            content.setMaxWidth(Main.scene.getWidth());
            WebView wv = (WebView) content.lookup("#webView");
            wv.setPrefHeight(Main.scene.getHeight()-200);
            wv.setPrefWidth(Main.scene.getWidth());
            wv.setMaxHeight(Main.scene.getHeight()-200);
            Button closeBtn = (Button) content.lookup("#closeBtn");
            closeBtn.setTranslateX(Main.scene.getWidth()/2);
            closeBtn.setTranslateY(- Main.scene.getHeight()/2);
            StackPane finalContent = content;
            WebEngine engine = wv.getEngine();
            engine.load(g.getUrl());
            closeBtn.setOnAction(e -> {
                new GameService().saveGame(
                        KidsspaceController.getChild().getId(),
                        g.getId(),
                        System.currentTimeMillis() - start
                );
                GameController.planet.getChildren().remove(finalContent);
                engine.load("");
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        GameController.planet.getChildren().add(content);
    }

    public void updateGame(int id) {

        GameService gs = new GameService();
        Game g = gs.findGame(id);
        g.setName("new game");
        gs.updateGame(g);
        g = gs.findGame(id);
        System.out.print(g);
    }

    private Double ColumnMaxWidth( double parentW , int columnCount, double spacing ){
        return (parentW - spacing * (columnCount-1))/columnCount;
    }
}
