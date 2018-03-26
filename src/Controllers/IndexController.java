package Controllers;

import Core.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class IndexController implements Initializable {

    @FXML
    private ImageView image;

    public void init() {
        VBox center = new VBox();
        try {
            center = FXMLLoader.load(getClass().getResource("/GUI/index.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        ScrollPane sp = new ScrollPane();
        sp.setContent(sp);
        Main.pane.setCenter(center);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        image.setFitWidth(Main.screen.getWidth());
    }
}
