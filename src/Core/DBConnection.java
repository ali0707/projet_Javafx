package Core;

import javafx.scene.control.Alert;
import javafx.scene.control.Dialog;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private Connection connection;
    public static DBConnection instance = null;

    private String DBname = "kidz-java";
    private String user = "root";
    private String pass = "";

    private DBConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost/" + this.DBname , this.user , this.pass);
        }catch(SQLException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Erreur de connexion avec la base de données");
            alert.setContentText("La connexion avec la base de données n'été pas aboutie car le serveur de base de données n'est pas disponible");
            alert.showAndWait();
            System.out.println("Connection error : " + e.getMessage());
        }catch (ClassNotFoundException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Erreur de connexion avec la base de données");
            alert.setContentText("La connexion avec la base de données n'a pas été aboutie car la bibliotéque mysql n'est pas intégrée dans le projet");
            alert.showAndWait();
            e.printStackTrace();
        }
    }
    
    public static DBConnection getInstance(){
        if(instance == null){
            instance = new DBConnection();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}
