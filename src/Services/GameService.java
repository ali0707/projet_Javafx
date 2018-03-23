package Services;

import Entities.Game;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class GameService extends Service {

    public void addGame(Game g){
        String sql =
                "INSERT INTO game (icon_id, name, url, age, device, category_id, gender) " +
                "VALUES (?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ps.setInt(1, g.getIconId());
            ps.setString(2, g.getName());
            ps.setString(3, g.getUrl());
            ps.setInt(4, g.getAge());
            ps.setString(5, g.getDevice());
            ps.setInt(6, g.getCategoryId());
            ps.setInt(7, g.getGender());
            ps.executeUpdate();
            System.out.println("Le jeu a été ajouté avec succes");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateGame(Game g){
        String sql =
                "UPDATE game " +
                "SET icon_id=?, name=?, url=?, age=?, device=?, category_id=?, gender=? " +
                "WHERE game.id = ?";
        try {
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ps.setInt(1, g.getIconId());
            ps.setString(2, g.getName());
            ps.setString(3, g.getUrl());
            ps.setInt(4, g.getAge());
            ps.setString(5, g.getDevice());
            ps.setInt(6, g.getCategoryId());
            ps.setInt(7, g.getGender());
            ps.setInt(8, g.getId());
            ps.executeUpdate();
            System.out.println("Le jeu a été modifié avec succes");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Game findGame(int id){
        String sql = "SELECT * FROM Game WHERE id = "+ id ;

        Game g = null;
        try {
            Statement stm = this.connection.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next()){
                g = new Game();
                g.setId(rs.getInt("id"));
                g.setAge(rs.getInt("age"));
                g.setDevice(rs.getString("device"));
                g.setCategoryId(rs.getInt("category_id"));
                g.setGender(rs.getInt("gender"));
                g.setIconId(rs.getInt("icon_id"));
                g.setName(rs.getString("name"));
                g.setUrl(rs.getString("url"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return g;
    }

    public ObservableList<Game> findAll(){
        String sql = "SELECT * FROM game";
        ObservableList<Game> games = FXCollections.observableArrayList();
        try {
            Statement stmt = this.connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                Game g = new Game();
                g.setAge(rs.getInt("age"));
                g.setDevice(rs.getString("device"));
                g.setCategoryId(rs.getInt("category_id"));
                g.setGender(rs.getInt("gender"));
                g.setIconId(rs.getInt("icon_id"));
                g.setName(rs.getString("name"));
                g.setUrl(rs.getString("url"));
                games.add(g);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return games;
    }

}
