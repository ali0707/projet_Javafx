/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Babysitter;
import Entities.Complaint;
import Entities.Photo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Meriem
 */
public class BabysitterService extends Service {

    public void addBabysitter(Babysitter g) throws SQLException {

//        String req = "INSERT INTO `babysitter`(`firstName`,`lastName`, `address`, `image_id`, `phone`, `state`, `price`) values (?,?,?,?,?,?,?)";
//
//        PreparedStatement pst = this.connection.prepareStatement(req);
//        pst.setString(1, b.getFirstName());
//        pst.setString(2, b.getLastName());
//        pst.setString(3, b.getAddress());
//        pst.setInt(4, b.getPhoto().getId());
//        pst.setString(5, b.getPhone());
//        pst.setString(6, b.getState());
//        pst.setInt(7, b.getPrice());
//        pst.executeUpdate();
//        System.out.println("c bon");
 String sqlPhoto = "INSERT INTO photos (url, alt) " +
                "VALUES (?,?)";

        String sql =
                "INSERT INTO `babysitter`(`firstName`,`lastName`, `address`, `image_id`, `phone`, `state`, `price`)" +
                "VALUES (?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = this.connection.prepareStatement(sqlPhoto, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, g.getPhoto().getUrl());
            ps.setString(2, g.getPhoto().getAlt());
            ps.executeUpdate();
            int photoId = 0;
            ResultSet rs = ps.getGeneratedKeys();
            while (rs.next()){
                photoId = rs.getInt(1);
            }
            g.getPhoto().setId(photoId);
            PreparedStatement pst = this.connection.prepareStatement(sql);
            pst.setString(1, g.getFirstName());
            pst.setString(2, g.getLastName());
            pst.setString(3, g.getAddress());
            pst.setInt(4, g.getPhoto().getId());
            pst.setString(5, g.getPhone());
            pst.setString(6, g.getState());
            pst.setInt(7, g.getPrice());
            pst.executeUpdate();
            
            g.getPhoto().moveToServer();
            System.out.println("c bn");
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public Babysitter findBabysitter(int id) {
        String sql = "SELECT * FROM babysitter WHERE id = " + id;
        Integer photoId = null;
        Babysitter c = null;
        try {
            Statement stm = this.connection.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                c = new Babysitter();
                c.setId(rs.getInt("id"));
                c.setFirstName(rs.getString("firstName"));
                c.setLastName(rs.getString("lastName"));
                c.setAddress(rs.getString("address"));
                c.setPhone(rs.getString("phone"));
                c.setState(rs.getString("state"));
                c.setPrice(rs.getInt("price"));
                photoId = rs.getInt("image_id");

            }
            Photo p = null;
            if (photoId != 0) {
                rs = stm.executeQuery("SELECT * FROM photos WHERE id =" + photoId);
                while (rs.next()) {
                    p = new Photo();
                    p.setId(photoId);
                    p.setAlt(rs.getString("alt"));
                    p.setUrl(rs.getString("url"));
                }
            }
            c.setPhoto(p);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return c;
    }

    public ObservableList<Babysitter> findAll() throws SQLException {
        Integer photoId = 0;
        ObservableList<Babysitter> babysitters = FXCollections.observableArrayList();
        String sql = "SELECT * FROM babysitter";
        PreparedStatement prs = this.connection.prepareStatement(sql);
        ResultSet resultat = prs.executeQuery();

        while (resultat.next()) {
            Babysitter c = new Babysitter();
            c.setId(resultat.getInt("id"));
            c.setFirstName(resultat.getString("firstName"));
            c.setLastName(resultat.getString("lastName"));
            c.setAddress(resultat.getString("address"));
            c.setPhone(resultat.getString("phone"));
            c.setState(resultat.getString("state"));
            c.setPrice(resultat.getInt("price"));
            photoId = resultat.getInt("image_id");
            Photo p = null;
            if (photoId != 0) {
                String rs = "SELECT * FROM photos WHERE id =" + photoId;
                prs = this.connection.prepareStatement(rs);
                ResultSet resultat1 = prs.executeQuery();
                while (resultat1.next()) {
                    p = new Photo();
                    p.setId(photoId);
                    p.setAlt(resultat1.getString("alt"));
                    p.setUrl(resultat1.getString("url"));
                }
            }
            c.setPhoto(p);
            System.out.println(c);
            babysitters.add(c);
        }
        return babysitters;
    }

    public void DeleteBabysitter(int id) throws SQLException {

        String req="Delete From babysitter where id=(?)";
            PreparedStatement prepared= this.connection.prepareStatement(req);
            prepared.setInt(1,id);
            prepared.executeUpdate();
        
    
    }

}
