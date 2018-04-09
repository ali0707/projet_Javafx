/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Core.Main;
import Entities.Address;
import Entities.Article;
import Entities.Category;
import Entities.Child;
import Entities.Photo;
import Services.AddressService;
import Services.ArticleService;
import Services.CategoryService;
import Services.ChildService;
import Services.PhotoService;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.web.HTMLEditor;
import javafx.scene.web.WebView;

/**
 *
 * @author Meriem
 */
public class ArticlesController {

    public void init() throws SQLException {

        VBox center = new VBox();
        VBox card = new VBox();

        ArticleService cs = new ArticleService();
        ImageView image;
        PhotoService is = new PhotoService();
        ObservableList<Article> articles = cs.findAll();

        try {
            center = FXMLLoader.load(getClass().getResource("/GUI/Article.fxml"));
            for (int i = 0; i < articles.size(); i += 1) {
                Article a = articles.get(i);
                card = FXMLLoader.load(getClass().getResource("/GUI/listArticles.fxml"));
                image = (ImageView) card.lookup("#image");
                Photo img = is.findImage(articles.get(i).getPhoto().getId());
                image.setImage(new Image(img.getWebPath()));
                Label title = (Label) card.lookup("#title");
                Label description = (Label) card.lookup("#description");
                Label subject = (Label) card.lookup("#subject");
                Label auteur = (Label) card.lookup("#auteur");
                title.setText(articles.get(i).getTitle());
                description.setText(articles.get(i).getDescription());
               
                WebView desc=(WebView) card.lookup("#desc");
                desc.getEngine().loadContent(articles.get(i).getDescription());
                subject.setText(articles.get(i).getSubject());
                auteur.setText(articles.get(i).getAuteur());
                Button more = (Button) card.lookup("#more");
                int finalI = i;
                System.out.println(a.getId());
                more.setOnAction(e -> this.showMore(a.getId()));
                center.getChildren().add(card);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        ScrollPane sp = new ScrollPane();
        sp.setContent(center);
        Main.pane.setCenter(sp);
    }

    private void showMore(int id) {

        try {
            VBox center = new VBox();
            VBox card = new VBox();

            CategoryService cv = new CategoryService();
            ObservableList<Category> categories = cv.findCategory("Article");
            VBox categories_container = new VBox();
            categories_container = (VBox) card.lookup("#categories");
            ArticleService cs = new ArticleService();
            ImageView image;
            PhotoService is = new PhotoService();
            ObservableList<Article> articles = cs.moreArticle(id);
            center = FXMLLoader.load(getClass().getResource("/GUI/Article.fxml"));
            System.out.println(categories.size());

            for (int i = 0; i < articles.size(); i += 1) {
                card = FXMLLoader.load(getClass().getResource("/GUI/MoreArticle.fxml"));
                image = (ImageView) card.lookup("#image");
                Photo img = is.findImage(articles.get(i).getPhoto().getId());
                image.setImage(new Image(img.getWebPath()));

                Label description = (Label) card.lookup("#description");
                Label title = (Label) card.lookup("#title");
                Label subject = (Label) card.lookup("#subject");
                Label auteur = (Label) card.lookup("#auteur");
                //Label date = (Label) card.lookup("#phone");
                title.setText(articles.get(i).getTitle());
                description.setText(articles.get(i).getDescription());
                subject.setText(articles.get(i).getSubject());
                auteur.setText(articles.get(i).getAuteur());
                center.getChildren().add(card);
                ScrollPane sp = new ScrollPane();
                sp.setContent(center);
                Main.pane.setCenter(sp);

            }
//             for (int i = 0; i < categories.size(); i += 1) {
//               
//                Label name=(Label) card.lookup("#cat");
//                name.setText(categories.get(i).getName()+"\n");
//                categories_container.getChildren().add(name);   
//                
//                
//
//            }
        } catch (IOException ex) {
            Logger.getLogger(ArticlesController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
