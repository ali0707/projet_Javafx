/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Core.Main;
import Entities.Address;
import Entities.Article;
import Entities.Babysitter;
import Entities.Category;
import Entities.Photo;
import Services.AddressService;
import Services.ArticleService;
import Services.BabysitterService;
import Services.CategoryService;
import Services.PhotoService;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author Meriem
 */
public class AddressController {

    public void init() throws SQLException {
        VBox center = new VBox();
        AddressService cs = new AddressService();
        VBox card = new VBox();
        ImageView image = new ImageView();
        ObservableList<Address> addresses = cs.findAll();

        try {
            center = FXMLLoader.load(getClass().getResource("/GUI/listAddresses.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(AddressController.class.getName()).log(Level.SEVERE, null, ex);
        }
        center.setMinWidth(Main.screen.getWidth());
        center.setMinHeight(Main.screen.getHeight());
        Label name;
        Label phone;
        Label description;
        Label location;

        GridPane list = new GridPane();
        PhotoService is = new PhotoService();
        list.setHgap(30);
        list.setVgap(30);
        list.setPadding(new Insets(10));
        for (int i = 0; i < addresses.size(); i++) {
            for (int j = 0; j < 3 && j + i * 3 < addresses.size(); j++) {
                Address a = addresses.get(j + i * 2);
                try {
                    card = FXMLLoader.load(getClass().getResource("/GUI/Address.fxml"));
                } catch (IOException ex) {
                    Logger.getLogger(AddressController.class.getName()).log(Level.SEVERE, null, ex);
                }
                image = (ImageView) card.getChildren().get(0);
                Photo img = is.findImage(addresses.get(j + i * 2).getPhoto().getId());
                image.setImage(new Image(img.getWebPath()));

                name = (Label) card.getChildren().get(1);
                name.setText(addresses.get(j + i * 2).getName());
                phone = (Label) card.getChildren().get(2);
                phone.setText(addresses.get(j + i * 2).getPhone());
                description = (Label) card.getChildren().get(2);

                description.setText(addresses.get(j + i * 2).getDescription().replace("<.*>", " "));
                location = (Label) card.getChildren().get(3);
                location.setText(addresses.get(i * 2 + j).getLocation());
                Button more = (Button) card.lookup("#more");
                int finalI = i;
                System.out.println(a.getId());
                more.setOnAction(e -> this.showMore(a.getId()));

                list.add(card, j, i);

            }

        }
        center.getChildren().add(list);

        ScrollPane sp = new ScrollPane();
        sp.setContent(center);
        Main.pane.setCenter(sp);
    }

    private void showMore(int id) {

        try {
            VBox center = new VBox();
            HBox card = new HBox();
            
            AddressService cs = new AddressService();
//            CategoryService cv= new CategoryService();
//            ObservableList<Category> categories = cv.findCategory("Adresse");
            ImageView image;
            PhotoService is = new PhotoService();
            ObservableList<Address> addresses = cs.moreAddress(id);
            center = FXMLLoader.load(getClass().getResource("/GUI/listAddresses.fxml"));

            for (int i = 0; i < addresses.size(); i += 1) {
                card = FXMLLoader.load(getClass().getResource("/GUI/MoreAddress.fxml"));
                image = (ImageView) card.lookup("#image");
                Photo img = is.findImage(addresses.get(i).getPhoto().getId());
                image.setImage(new Image(img.getWebPath()));
                Label name = (Label) card.lookup("#name");
                Label description = (Label) card.lookup("#description");
                Label location = (Label) card.lookup("#location");
                Label phone = (Label) card.lookup("#phone");
                name.setText(addresses.get(i).getName());
                description.setText(addresses.get(i).getDescription());
                location.setText(addresses.get(i).getLocation());
                phone.setText(addresses.get(i).getPhone());
                center.getChildren().add(card);
                ScrollPane sp = new ScrollPane();
                sp.setContent(center);
                Main.pane.setCenter(sp);

            }
        } catch (SQLException ex) {
            Logger.getLogger(AddressController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AddressController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
