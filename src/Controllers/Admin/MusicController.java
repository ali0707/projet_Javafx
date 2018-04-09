package Controllers.Admin;

import Controllers.AdminController;
import Dependencies.pherialize.MixedArray;
import Dependencies.pherialize.Pherialize;
import Entities.Music;
import Services.MusicService;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MusicController {

    public void init() {
        VBox content = null;
        try {
            content = FXMLLoader.load(getClass().getResource("/GUI/Admin/music-list.fxml"));
            VBox body = (VBox) content.lookup("#panelBody");
            content.setPrefWidth(AdminController.container.getWidth());
            content.setPrefHeight(AdminController.container.getHeight());
            Button addBtn = (Button) content.lookup("#addBtn");
            addBtn.setOnAction(e -> addMusic());

            TableColumn<Music, Integer> idColumn = new TableColumn<>("ID");
            idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
            idColumn.setMaxWidth(50);
            idColumn.setMinWidth(50);
            idColumn.setStyle("-fx-alignment : center");

            TableColumn<Music, String> titleColumn = new TableColumn<>("Title");
            titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));

            TableColumn<Music, Date> durationColumn = new TableColumn<>("Duration");
            durationColumn.setCellValueFactory(new PropertyValueFactory<>("duration"));
            durationColumn.setCellFactory(e -> new TableCell<Music, Date>(){
                @Override
                public void updateItem(Date item, boolean empty){
                    super.updateItem(item, empty);
                    if (item!= null && !empty){

                        int seconds  = (int) (item.getTime() / 1000);
                        int minutes = (int) (item.getTime() / 60000);
                        setText(minutes + " minutes et " + seconds + " secondes");
                    }
                }
            });

            TableColumn<Music, String> singerColumn = new TableColumn<>("SINGER");
            singerColumn.setCellValueFactory(new PropertyValueFactory<>("singer"));
//            singerColumn.setCellFactory(e -> new TableCell<Music, Boolean>(){
//                @Override
//                public void updateItem(Boolean item, boolean empty){
//                    super.updateItem(item, empty);
//                    setText(empty ? null : item ? "Activé" : "Désactivé");
//                }
//            });

//            TableColumn<Music, String> rolesColumn = new TableColumn<>("PRIVILEGES");
//            rolesColumn.setCellValueFactory(new PropertyValueFactory<>("roles"));
//            rolesColumn.setCellFactory(e -> new TableCell<Music, String>(){
//                @Override
//                public void updateItem(String roles, boolean empty){
//                    super.updateItem(roles, empty);
//                    if (!empty){
//                        MixedArray rolesList = Pherialize.unserialize(roles).toArray();
//                        String text = "";
//                        for (int i = 0; i < rolesList.size(); i++){
//                            if (i > 0) text += ", ";
//                            switch (rolesList.getString(i)){
//                                case "ROLE_SUPER_ADMIN" :
//                                    text += "Super admin";
//                                    break;
//                                case "ROLE_ADMIN" :
//                                    text += "Admin";
//                                    break;
//                                case "ROLE_PARENT" :
//                                    text += "Parent";
//                                    break;
//                                case "ROLE_PROVIDER" :
//                                    text += "Fournisseur";
//                                    break;
//                                default: text += "Utilisateur";
//                            }
//                        }
//                        setText(text);
//                    }
//                }
//            });

//            TableColumn<Music, Timestamp> dateColumn = new TableColumn<>("DERNIERE CONNEXION");
//            dateColumn.setCellValueFactory(new PropertyValueFactory<>("lastLogin"));
//            dateColumn.setCellFactory(e -> new TableCell<Music, Timestamp>(){
//                @Override
//                protected void updateItem(Timestamp item, boolean empty) {
//                    super.updateItem(item, empty);
//                    if (!empty && item != null){
//                        SimpleDateFormat dt = new SimpleDateFormat("d MMMM, y");
//                        setText(dt.format(item));
//                    }
//                    else if (!empty) setText("Aucune connexion");
//                }
//            });
            TableView tableView = (TableView) body.lookup("#table");
            tableView.setItems(new MusicService().findAll());
            tableView.getColumns().addAll(idColumn,titleColumn,durationColumn, singerColumn);
        } catch (IOException e) {
            e.printStackTrace();
        }
        AdminController.container.getChildren().clear();
        AdminController.container.getChildren().add(content);
    }

    public void addMusic(){
        AdminController.treeView.getSelectionModel().select(3);
        VBox content = null;
        try {
            content = FXMLLoader.load(getClass().getResource("/GUI/Admin/form-user.fxml"));
            content.setPrefWidth(AdminController.container.getWidth());
            content.setPrefHeight(AdminController.container.getHeight());
            TextField email = (TextField) content.lookup("#email");
            TextField login = (TextField) content.lookup("#login");
            TextField passwd = (TextField) content.lookup("#passwd");
            ComboBox roles = (ComboBox) content.lookup("#roles");
            Button save = (Button) content.lookup("#save");

            save.setOnAction(e -> {
//                Music u = new Music(login.getText(), passwd.getText(), email.getText());
//                new MusicService().registerMusic(u);
                init();
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        AdminController.container.getChildren().clear();
        AdminController.container.getChildren().add(content);
    }


}

