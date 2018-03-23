package Controllers;

import Entities.Game;
import javafx.collections.ObservableList;
import Dependencies.pherialize.Pherialize;
import Services.GameService;

import java.util.ArrayList;
import java.util.List;

public class GameController {

    public void addGame(){
        List list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        list.add("3");
        String devs = Pherialize.serialize(list);
        Game g = new Game(3,"game", "url",1,devs, 1, 2);
        GameService gs = new GameService();

        gs.addGame(g);
    }

    public void deleteGame(int id){
        GameService gs = new GameService();
        gs.deleteObject(id, "game");
    }

    public void showGame(int id){
        GameService gs = new GameService();
        Game g = gs.findGame(id);
        System.out.println(g);
    }

    public void updateGame(int id) {

        GameService gs = new GameService();
        Game g = gs.findGame(id);
        g.setName("new game");
        gs.updateGame(g);
        g = gs.findGame(id);
        System.out.print(g);
    }

    public void listGames(){
        GameService gs = new GameService();
        System.out.println("Liste des jeux");
        ObservableList<Game> games = gs.findAll();
        for (Game g : games){
            System.out.println(g);
        }
    }
}
