package Controllers.Admin;

import Controllers.AdminController;
import Core.Main;
import Dependencies.pherialize.MixedArray;
import Dependencies.pherialize.Pherialize;
import Entities.Babysitter;
import Entities.Category;
import Entities.Game;
import Entities.Photo;
import Services.BabysitterService;
import Services.GameService;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIcon;
import java.io.File;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

public class BabysitterController {
private File image = null;
    public void init() {
        VBox content = null;
        
        try {
            content = FXMLLoader.load(getClass().getResource("/GUI/admin/babysitter-list.fxml"));
            VBox body = (VBox) content.lookup("#panelBody");
            content.setPrefWidth(AdminController.container.getWidth());
            content.setPrefHeight(AdminController.container.getHeight());
            Button addBtn = (Button) content.lookup("#addBtn");
            addBtn.setOnAction(e -> addBabysitter());

            TableColumn<Babysitter, Integer> idColumn = new TableColumn<>("ID");
            idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
            idColumn.setMaxWidth(50);
            idColumn.setMinWidth(50);
            idColumn.setStyle("-fx-alignment : center");

            TableColumn<Babysitter, String> lastnameColumn = new TableColumn<>("NOM");
            lastnameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));

            TableColumn<Babysitter, String> firstnameColumn = new TableColumn<>("PRENOM");
            firstnameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));

            TableColumn<Babysitter, String> phoneColumn = new TableColumn<>("TELEPHONE");
            phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));

            TableColumn<Babysitter, String> addressColumn = new TableColumn<>("REGION");
            addressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));

            TableColumn<Babysitter, Integer> priceColumn = new TableColumn<>("SALAIRE");
            priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

            TableColumn<Babysitter, Photo> photoColumn = new TableColumn<>("IMAGE");
            photoColumn.setCellValueFactory(new PropertyValueFactory<>("photo"));
            photoColumn.setCellFactory(e -> new TableCell<Babysitter, Photo>(){
                @Override
                public void updateItem(Photo item, boolean empty){
                    super.updateItem(item, empty);
                    if(!empty && item!= null){
                        ImageView iv = new ImageView(new Image(item.getWebPath()));
                        iv.setFitHeight(150);
                        iv.setPreserveRatio(true);
                        setText("");
                        setGraphic(iv);
                    }
                }
            });

            TableColumn<Babysitter, String> stateColumn = new TableColumn<>("ETAT");
            stateColumn.setCellValueFactory(new PropertyValueFactory<>("state"));

//            stateColumn.setCellFactory(e -> new TableCell<Babysitter, Boolean>(){
//                @Override
//                public void updateItem(Boolean item, boolean empty){
//                    super.updateItem(item, empty);
//                    setText(empty ? null : item ? "Activé" : "Désactivé");
//                }
//            });
//            TableColumn<Babysitter, String> rolesColumn = new TableColumn<>("PRIVILEGES");
//            rolesColumn.setCellValueFactory(new PropertyValueFactory<>("roles"));
//            rolesColumn.setCellFactory(e -> new TableCell<Babysitter, String>(){
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
//
//            TableColumn<Babysitter, Timestamp> dateColumn = new TableColumn<>("DERNIERE CONNEXION");
//            dateColumn.setCellValueFactory(new PropertyValueFactory<>("lastLogin"));
//            dateColumn.setCellFactory(e -> new TableCell<Babysitter, Timestamp>(){
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
            try {
                tableView.setItems(new BabysitterService().findAll());
            } catch (SQLException ex) {
                Logger.getLogger(BabysitterController.class.getName()).log(Level.SEVERE, null, ex);
            }
            tableView.getColumns().addAll(idColumn, lastnameColumn, firstnameColumn, phoneColumn, addressColumn, priceColumn, photoColumn, stateColumn);
        } catch (IOException e) {
            e.printStackTrace();
        }
        AdminController.container.getChildren().clear();
        AdminController.container.getChildren().add(content);
    }

    public void addBabysitter() {
        
    try {
        AdminController.treeView.getSelectionModel().select(3);
        VBox content = null;
        BabysitterService bs= new BabysitterService();
        
        
        content = FXMLLoader.load(getClass().getResource("/GUI/admin/form-babysitter.fxml"));
        content.setPrefWidth(AdminController.container.getWidth());
        content.setPrefHeight(AdminController.container.getHeight());
        TextField prenom = (TextField) content.lookup("#firstname");
        TextField nom = (TextField) content.lookup("#lastname");
        TextField telephone = (TextField) content.lookup("#phone");
        // TextField image= (TextField)center.lookup("#subject");
       
        TextField salaire = (TextField) content.lookup("#sal");
          ComboBox  address = (ComboBox) content.lookup("#address");
          address.setVisibleRowCount(25);
          
      

         address.getItems().addAll("Ariana","Ben Arous","Mahdia","Gabes","Sousse");
          
         
        TextField etat = (TextField) content.lookup("#state");
        
        Button save = (Button) content.lookup("#save");
        Button icon = (Button) content.lookup("#icon");
        FileChooser fc = new FileChooser();
        fc.setTitle("Choisir une icone");
        FileChooser.ExtensionFilter fe = new FileChooser.ExtensionFilter("Image files", "*.png", ".jpg");
        fc.setSelectedExtensionFilter(fe);
        icon.setOnAction(e -> image = fc.showOpenDialog(Main.window));
        save.setOnAction(e -> {
            try {
                Photo imageFile = new Photo(image);
                Babysitter u = new Babysitter(prenom.getText(), nom.getText(), address.getValue().toString(), Integer.parseInt(salaire.getText()), telephone.getText(), etat.getText(), imageFile);
                
                
                
                
                new BabysitterService().addBabysitter(u);
                init();
            } catch (SQLException ex) {
                Logger.getLogger(BabysitterController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        
        
        
        
        AdminController.container.getChildren().clear();
        AdminController.container.getChildren().add(content);
    } catch (IOException ex) {
        Logger.getLogger(BabysitterController.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

}
