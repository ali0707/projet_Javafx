package Controllers;

import Entities.Cartoon;
import Entities.Video;
import javafx.collections.ObservableList;
import Services.CartoonService;
import Services.VideoService;

public class CartoonController {

    public void addCartoon(){
        Cartoon c = new Cartoon(3, "url", 60, 2, 1, "cartoon");
        CartoonService cs = new CartoonService();

        cs.addCartoon(c);
    }

    public void deleteCartoon(int id){
        CartoonService cs = new CartoonService();
        cs.deleteObject(id,"Cartoon");
    }

    public void showCartoon(int id){
        CartoonService cs = new CartoonService();
        Cartoon c = cs.findCartoon(id);
        System.out.println(c);
    }

    public void updateCartoon(int id) {

        CartoonService cs = new CartoonService();
        Cartoon c = cs.findCartoon(id);
        c.setName("new came");
        cs.updateCartoon(c);
        c = cs.findCartoon(id);
        System.out.print(c);
    }

    public void listCartoons(){
        CartoonService cs = new CartoonService();
        System.out.println("Liste des cartoon");
        ObservableList<Cartoon> cartoons = cs.findAll();
        for (Cartoon c : cartoons){
            System.out.println(c);
        }
    }

    public void addEpisode(int id){
        VideoService vs = new VideoService();
        Video v = new Video(null, "url",null, 0, id, 4, "Episode 1");
        vs.addEpisode(v);
    }


    public void listEpisodes(int id) {
        VideoService vs = new VideoService();
        ObservableList<Video> episodes = vs.findEpisodes(id);
        for (Video v : episodes){
            System.out.println(v);
        }
    }

    public void deleteEpisode(int id){
        VideoService vs = new VideoService();
        vs.deleteObject(id, "video");
    }
}
