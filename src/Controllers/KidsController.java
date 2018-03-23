package Controllers;

import Core.Main;
import Entities.Child;
import Services.ChildService;
import Services.ImageService;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;

import java.io.IOException;

public class KidsController {

    public void init(){

        VBox center = new VBox();
        ChildService cs = new ChildService();
        ObservableList<Child> mykids = cs.findMykids(Main.user.getId());
        try {
            center = FXMLLoader.load(getClass().getResource("/GUI/kids.fxml"));
            center.setMinWidth(Main.screen.getWidth());
            center.setMinHeight(Main.screen.getHeight());
            GridPane list = new GridPane();
            list.setHgap(30);
            for (int i = 0 ; i < mykids.size(); i+=2 ){
                for (int j = i ; j < i+2; j++){
                    Pane card = new Pane();
                    HBox paneLayout = new HBox();
                    VBox infos = new VBox();
                    infos.setPadding(new Insets(20));
                    infos.getStyleClass().removeAll();
                    infos.getStyleClass().add("media-body");
                    infos.setStyle("-fx-text-fill: white");
                    card.getChildren().add(paneLayout);
                    ImageService is= new ImageService();
                    Entities.Image img = is.findImage(mykids.get(j).getPhotoId());
                    ImageView imageView = new ImageView(new Image(img.getWebPath()));
                    imageView.setFitHeight(270);
                    imageView.setFitWidth(267.5);
                    Rectangle clip = new Rectangle();
                    clip.setHeight(270);
                    clip.setWidth(267.5);
                    clip.getStyleClass().add("media-image");
                    clip.setArcHeight(13);
                    imageView.setClip(clip);
                    infos.setMinWidth(267.5);
                    card.getStyleClass().addAll("media", "bg-color-4");
                    paneLayout.getChildren().addAll(imageView, infos);
                    Label name = new Label(mykids.get(j).getName());
                    name.setStyle("-fx-font-family: 'Dosis', sans-serif");
//                    name.setStyle("-fx-font-size: 24px");
                    Label age = new Label(mykids.get(j).getAge() + " ans");
                    Label desc = new Label("2 Heures restants pour aujourd'hui");
                    infos.getChildren().addAll(name, age, desc);
                    list.add(card,j,i);
                }
            }
            center.getChildren().add(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Main.body.setContent(center);
    }

}
