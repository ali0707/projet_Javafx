package Controllers;

import Core.Main;
import Entities.Child;
import Entities.Photo;
import Services.ChildService;
import Services.ImageService;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
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
            list.setVgap(30);
            list.setPadding(new Insets(10));
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
                    more = (Button) card.lookup("#more");
                    int finalJ = j;
                    more.setOnAction(e -> this.showMore(mykids.get(finalJ)));
                    space = (Button) card.lookup("#space");
                    space.setOnAction(e -> this.showSpace(mykids.get(finalJ)));
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

    private void showMore(Child child){

    }

    private void showSpace(Child child) {
        VBox center = new VBox();
        try {
            center = FXMLLoader.load(getClass().getResource("/GUI/kidspaceText.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Main.pane.setCenter(center);
        center.setOnMouseClicked(e -> openSpace());
    }

    private void openSpace() {
        Main.window.setFullScreen(true);
        KeyCodeCombination kcc = new KeyCodeCombination(KeyCode.K, KeyCodeCombination.CONTROL_DOWN,KeyCodeCombination.ALT_DOWN);
        Main.window.setFullScreenExitHint("");
        Main.window.setFullScreenExitKeyCombination(kcc);

    }

}
