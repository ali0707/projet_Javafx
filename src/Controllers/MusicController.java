package Controllers;

import Entities.Music;
import javafx.collections.ObservableList;
import Services.MusicService;

public class MusicController {

    public void addMusic(){
        Music c = new Music("music", 220, "singer", 18, "url", "music");
        MusicService ms = new MusicService();

        ms.addMusic(c);
    }

    public void deleteMusic(int id){
        MusicService ms = new MusicService();
        ms.deleteObject(id,"Music");
    }

    public void showMusic(int id){
        MusicService ms = new MusicService();
        Music c = ms.findMusic(id);
        System.out.println(c);
    }

    public void updateMusic(int id) {

        MusicService ms = new MusicService();
        Music c = ms.findMusic(id);
        c.setTitle("new music");
        ms.updateMusic(c);
        c = ms.findMusic(id);
        System.out.print(c);
    }

    public void listSongs(){
        MusicService ms = new MusicService();
        System.out.println("Liste des chansons");
        ObservableList<Music> musics = ms.findAll();
        for (Music c : musics){
            System.out.println(c);
        }
    }
}
