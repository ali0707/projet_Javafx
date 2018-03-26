package Controllers;

import Core.Main;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HeaderController implements Initializable{

    public FontAwesomeIconView signIcon;

    @FXML
    public Button signOutBtn;
    @FXML
    public Button editProfileBtn;

    @FXML
    private Button loginLink;

    @FXML
    private Button profileBtn;

    @FXML
    private Button home;

    @FXML
    private VBox parentToggle;

    @FXML
    private VBox shopToggle;

    @FXML
    private VBox eventToggle;

    @FXML
    private VBox kidsToggle;


    private static VBox childMenu;
    private static VBox parentMenu;
    private static VBox shopMenu;
    private static VBox eventMenu;

    @FXML
    public void kidsCombo(){

    }

    @FXML
    public void shopCombo(){

    }

    @FXML
    public void parentCombo(){

    }

    @FXML
    public void eventsCombo(){

    }

    public void showKidMenu(){
        childMenu.setOpacity(0);
        childMenu.setStyle("-fx-text-fill: #f0c24b");
    }

    public void init() {
        parentToggle = (VBox) Main.sp.lookup("#parentToggle");
        kidsToggle = (VBox) Main.sp.lookup("#kidsToggle");
        shopToggle = (VBox) Main.sp.lookup("#shopToggle");
        eventToggle= (VBox) Main.sp.lookup("#eventToggle");
        try {
            childMenu = FXMLLoader.load(getClass().getResource("/GUI/header-dropdown.fxml"));
            parentMenu = FXMLLoader.load(getClass().getResource("/GUI/header-dropdown.fxml"));
            shopMenu = FXMLLoader.load(getClass().getResource("/GUI/header-dropdown.fxml"));
            eventMenu = FXMLLoader.load(getClass().getResource("/GUI/header-dropdown.fxml"));

            //TODO: Add buttons to your list and link them to their controllers Here \/

            Button kids = new Button("Mes enfants");
            kids.setOnAction(e -> new KidsController().init());
            childMenu.getChildren().addAll(kids);

            Button articles = new Button("Articles");
            Button forum = new Button("Forum");
            parentMenu.getChildren().addAll(articles, forum);

            //TODO: Add buttons to your list and link them to their controllers above /\

            parentMenu.getStyleClass().add("bdr-color-3");
            parentMenu.setTranslateY(guestY(parentMenu));
            parentMenu.setTranslateX(190);
            parentMenu.setOnMouseExited(e -> parentMenu.getStyleClass().removeAll("visible"));
            shopMenu.getStyleClass().add("bdr-color-1");
            shopMenu.setTranslateY(guestY(shopMenu));
            shopMenu.setTranslateX(320);
            shopMenu.setOnMouseExited(e -> shopMenu.getStyleClass().removeAll("visible"));
            eventMenu.getStyleClass().add("bdr-color-2");
            eventMenu.setTranslateY(guestY(eventMenu));
            eventMenu.setTranslateX(450);
            eventMenu.setOnMouseExited(e -> eventMenu.getStyleClass().removeAll("visible"));
            childMenu.getStyleClass().add("bdr-color-4");
            childMenu.setTranslateY(guestY(childMenu));
            childMenu.setTranslateX(Main.sp.getWidth()/2 -115);
            childMenu.setOnMouseExited(e -> childMenu.getStyleClass().removeAll("visible"));
            Main.sp.getChildren().addAll(parentMenu, shopMenu, eventMenu, childMenu);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        kidsToggle.setOnMouseEntered(e -> childMenu.getStyleClass().add("visible"));
        parentToggle.setOnMouseEntered(e -> parentMenu.getStyleClass().add("visible"));
        shopToggle.setOnMouseEntered(e -> shopMenu.getStyleClass().add("visible"));
        eventToggle.setOnMouseEntered(e -> eventMenu.getStyleClass().add("visible"));
        loginLink.setOnAction(e -> new UsersController().showLogin());
        signOutBtn.setOnAction( e -> new UsersController().logOut());
        home.setOnAction(e -> new IndexController().init());
    }

    private double guestY(VBox v){
        double childrenHeight = (v.getChildren().size() * 30) / 2;
        return 190 - Main.screen.getHeight()/ 2 + childrenHeight;
    }

}
