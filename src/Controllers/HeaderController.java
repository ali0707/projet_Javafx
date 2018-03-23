package Controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

import java.net.URL;
import java.util.ResourceBundle;

public class HeaderController implements Initializable {

    @FXML
    private ComboBox<?> shopMenu;

    @FXML
    private Button loginBtn;

    @FXML
    private ComboBox<String> kidsMenu;

    @FXML
    private Button profile;

    @FXML
    private ComboBox<?> eventsMenu;

    @FXML
    private ComboBox<?> parentMenu;

    @FXML
    private Button home;

    @FXML
    public void kidsCombo(){

        if (kidsMenu.getValue().equals("Mes Enfants")){
            KidsController kc = new KidsController();
            kc.init();
        }

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        kidsMenu.getItems().add("Mes Enfants");
    }
}
