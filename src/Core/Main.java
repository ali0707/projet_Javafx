package Core;

import Controllers.IndexController;
import Entities.User;
import Services.UserService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;


public class Main extends Application {

    public static Stage window;
    public static Rectangle2D screen;
    public static BorderPane pane;
    public static ScrollPane body;
    public static User user = null;

    public Scene scene;

    @Override
    public void start(Stage primaryStage) throws Exception{
        user = new UserService().findUser(10);
        window = primaryStage;
        screen = Screen.getPrimary().getBounds();
        pane = new BorderPane();
        pane.getStylesheets().add("https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700");
        pane.getStylesheets().add("https://fonts.googleapis.com/css?family=Dosis:300,400,600,700,800");
        pane.getStylesheets().add("/assets/css/styles.css");
        VBox top = FXMLLoader.load(getClass().getResource("/GUI/header.fxml"));
        pane.setTop(top);
        body = new ScrollPane();
        pane.setCenter(body);
        double width = screen.getWidth();
        double height = screen.getHeight() - 70;
        scene = new Scene(pane, width, height);
        window.setX(screen.getMinX() - 10);
        window.setY(screen.getMinY());
        window.setTitle("Kidzo");
        window.setScene(scene);
        IndexController indexController = new IndexController();
        indexController.init();
        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }


}
