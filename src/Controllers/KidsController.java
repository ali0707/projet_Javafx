package Controllers;

import Core.Main;
import Entities.Child;
import Entities.ChildGame;
import Entities.Game;
import Entities.Photo;
import Services.ChildService;
import Services.GameService;
import Services.PhotoService;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
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

    public void init() {
        VBox center = new VBox();
        ChildService cs = new ChildService();
        ObservableList<Child> mykids = cs.findMykids(Main.user.getId());
        try {
            center = FXMLLoader.load(getClass().getResource("/GUI/kids.fxml"));
            center.setMinWidth(Main.screen.getWidth());
            center.setMinHeight(Main.screen.getHeight());
            GridPane list = new GridPane();
            PhotoService is = new PhotoService();
            list.setHgap(30);
            list.setVgap(30);
            list.setPadding(new Insets(10));
            for (int i = 0; i < mykids.size(); i++) {
                for (int j = i; j < 2 && j+i*2 < mykids.size(); j++) {
                    card = FXMLLoader.load(getClass().getResource("/GUI/ChildCard.fxml"));
                    image = (ImageView) card.getChildren().get(0);
                    Photo img = is.findImage(mykids.get(j+i*2).getPhotoId());
                    image.setImage(new Image(img.getWebPath()));
                    VBox right = (VBox) card.getChildren().get(1);
                    name = (Label) right.getChildren().get(0);
                    name.setText(mykids.get(j+i*2).getName());
                    age = (Label) right.getChildren().get(1);
                    age.setText(mykids.get(j+i*2).getAge() + " ans");
                    time_left = (Label) right.getChildren().get(2);
                    time_left.setText("2 Heures restants pour aujourd'hui");
                    description = (Label) right.getChildren().get(3);
                    description.setText("Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor");
                    more = (Button) card.lookup("#more");
                    int finalJ = j;
                    more.setOnAction(e -> this.showActivity(mykids.get(finalJ)));
                    space = (Button) card.lookup("#space");
                    space.setOnAction(e -> this.showSpace(mykids.get(finalJ)));
                    list.add(card, j, i);
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

    private void showActivity(Child child) {
        ScrollPane center = new ScrollPane();
        try {
            center = FXMLLoader.load(getClass().getResource("/GUI/child-activity.fxml"));
            center.setFitToHeight(true);
//            Barchbarchart("Unit Sales Q2 2016", CategoryAxis(), NumberAxis()) {
//                series("Product X") {
//                    data("MAR", 10245)
//                    data("APR", 23963)
//                    data("MAY", 15038)
//                }
//                series("Product Y") {
//                    data("MAR", 28443)
//                    data("APR", 22845)
//                    data("MAY", 19045)
//                }
//            }
            VBox gameList = (VBox) center.getContent().lookup("#gameList");
            ObservableList<ChildGame> recent = new GameService().getRecent(child.getId());
            for(int i = 0; i< recent.size(); i++){
                ChildGame cg = recent.get(i);
                HBox game = FXMLLoader.load(getClass().getResource("/GUI/game-list-item.fxml"));
                ImageView image = (ImageView) game.lookup("#image");
                if (cg.getGame().getIcon() != null)
                    image.setImage(new Image(cg.getGame().getIcon().getWebPath()));
                Label name = (Label) game.lookup("#name");
                name.setText(cg.getGame().getName());
                Label date = (Label) game.lookup("#date");
                date.setText(date.getText() + " " + cg.getDate().toString());
                Label duration = (Label) game.lookup("#duration");
                duration.setText(duration.getText() + " " + cg.getDuration().toString());
                gameList.getChildren().add(game);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        center.setFitToHeight(false);
        Main.pane.setCenter(center);
    }

//    private void showMore(Child child) {
//
//    }

    private void showSpace(Child child) {
        VBox center = new VBox();
        try {
            center = FXMLLoader.load(getClass().getResource("/GUI/kidspace-text.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Main.pane.setCenter(center);
        center.setOnMouseClicked(e -> new KidsspaceController().openSpace(child));
    }

}
