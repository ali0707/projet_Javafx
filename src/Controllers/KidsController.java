package Controllers;

import Core.Main;
import Entities.Child;
import Entities.Photo;
import Services.ChildService;
import Services.ImageService;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class KidsController {


    @FXML
    private ImageView image;

    @FXML
    private Label time_left;

    @FXML
    private Button more;

    @FXML
    private Label name;

    @FXML
    private Label description;

    @FXML
    private HBox card;

    @FXML
    private Label age;

    @FXML
    private Button space;

    public void init(){
        VBox center = new VBox();
        ChildService cs = new ChildService();
        ObservableList<Child> mykids = cs.findMykids(Main.user.getId());
        try {
            center = FXMLLoader.load(getClass().getResource("/GUI/kids.fxml"));
            center.setMinWidth(Main.screen.getWidth());
            center.setMinHeight(Main.screen.getHeight());
            GridPane list = new GridPane();
            ImageService is= new ImageService();
            list.setHgap(30);
            for (int i = 0 ; i < mykids.size(); i+=2 ){
                for (int j = i ; j < i+2; j++){
                    card = FXMLLoader.load(getClass().getResource("/GUI/ChildCard.fxml"));
                    image = (ImageView) card.getChildren().get(0);
                    Photo img = is.findImage(mykids.get(j).getPhotoId());
                    image.setImage(new Image(img.getWebPath()));
                    VBox right = (VBox) card.getChildren().get(1);
                    name = (Label) right.getChildren().get(0);
                    name.setText(mykids.get(j).getName());
                    age = (Label) right.getChildren().get(1);
                    age.setText(mykids.get(j).getAge() + " ans");
                    time_left = (Label) right.getChildren().get(2);
                    time_left.setText("2 Heures restants pour aujourd'hui");
                    description = (Label) right.getChildren().get(3);
                    description.setText("Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor");
                    list.add(card,j,i);
                }
            }
            center.getChildren().add(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ScrollPane sp = new ScrollPane();
        sp.setContent(center);
        Main.pane.setCenter(sp);

    }

}
