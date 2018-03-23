package Services;

import Entities.Cartoon;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class CartoonService extends Service {

    public void addCartoon(Cartoon c){
        String sql =
                "INSERT INTO cartoon (photo_id, name, summary, age, episodesCnt, gender) " +
                        "VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ps.setInt(1, c.getPhotoId());
            ps.setString(2, c.getName());
            ps.setString(3, c.getSummary());
            ps.setInt(4, c.getAge());
            ps.setInt(5, c.getEpisodesCnt());
            ps.setInt(6, c.getGender());
            ps.executeUpdate();
            System.out.println("Le cartoon a été ajouté avec succes");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateCartoon(Cartoon c){
        String sql =
                "UPDATE cartoon " +
                        "SET photo_id=?, name=?, summary=?, age=?, gender=? " +
                        "WHERE cartoon.id = ?";
        try {
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ps.setInt(1, c.getPhotoId());
            ps.setString(2, c.getName());
            ps.setString(3, c.getSummary());
            ps.setInt(4, c.getAge());
            ps.setInt(5, c.getGender());
            ps.setInt(6, c.getId());
            ps.executeUpdate();
            System.out.println("Le cartoon a été modifié avec succes");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Cartoon findCartoon(int id){
        String sql = "SELECT * FROM cartoon WHERE id = "+ id ;

        Cartoon c = null;
        try {
            Statement stm = this.connection.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next()){
                c = new Cartoon();
                c.setId(rs.getInt("id"));
                c.setAge(rs.getInt("age"));
                c.setGender(rs.getInt("gender"));
                c.setName(rs.getString("name"));
                c.setSummary(rs.getString("summary"));
                c.setPhotoId(rs.getInt("photo_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return c;
    }

    public ObservableList<Cartoon> findAll(){
        String sql = "SELECT * FROM cartoon";
        ObservableList<Cartoon> cartoons = FXCollections.observableArrayList();
        try {
            Statement stmt = this.connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                Cartoon c = new Cartoon();
                c.setId(rs.getInt("id"));
                c.setAge(rs.getInt("age"));
                c.setGender(rs.getInt("gender"));
                c.setName(rs.getString("name"));
                c.setSummary(rs.getString("summary"));
                c.setEpisodesCnt(rs.getInt("episodesCnt"));
                c.setPhotoId(rs.getInt("photo_id"));
                cartoons.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cartoons;
    }

}
