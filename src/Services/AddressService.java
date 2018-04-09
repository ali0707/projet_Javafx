/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Address;
import Entities.Article;
import Entities.Category;
import Entities.Photo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Meriem
 */
public class AddressService extends Service {

    public ObservableList<Address> findAll() throws SQLException {
        Integer photoId = 0;
        Integer CategoryId = 0;
        ObservableList<Address> addresses = FXCollections.observableArrayList();
        String sql = "SELECT * FROM address";
        PreparedStatement prs = this.connection.prepareStatement(sql);
        ResultSet resultat = prs.executeQuery();

        while (resultat.next()) {
            Address c = new Address();
            c.setId(resultat.getInt("id"));
            //c.setCategory(resultat.getInt("category"));
            c.setDescription(resultat.getString("description"));
            c.setLocation(resultat.getString("location"));
            c.setName(resultat.getString("name"));
            c.setPhone(resultat.getString("phone"));
            c.setLat(resultat.getFloat("lat"));
            c.setLng(resultat.getFloat("lng"));
            CategoryId = resultat.getInt("category");
            Category cat = null;
            if (CategoryId != 0) {
                String rs = "SELECT * FROM category WHERE id =" + CategoryId;
                prs = this.connection.prepareStatement(rs);
                ResultSet resultat1 = prs.executeQuery();
                while (resultat1.next()) {
                    cat = new Category();
                    cat.setId(CategoryId);
                    cat.setName(resultat1.getString("name"));
                    cat.setType(resultat1.getString("type"));
                }
            }
            c.setCategory(cat);
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
            addresses.add(c);
        }
        return addresses;
    }

    public ObservableList <Address> moreAddress(int id) throws SQLException {
        ObservableList<Address> addresses = FXCollections.observableArrayList();
        Address a = new Address();
        String sql = "SELECT * FROM address WHERE id ="+ id;
        Statement stmt = this.connection.createStatement();
        Integer photoId = 0;
        Integer categoryId = 0;
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            a.setId(rs.getInt("id"));
            a.setDescription(rs.getString("description"));
            a.setLocation(rs.getString("location"));
            a.setName(rs.getString("name"));
            a.setPhone(rs.getString("phone"));
            a.setLat(rs.getFloat("lat"));
            a.setLng(rs.getFloat("lng"));
            photoId = rs.getInt("image_id");
            categoryId = rs.getInt("category");
            Photo p = null;
            if (photoId != 0) {
                p = new PhotoService().findImage(photoId);
            }
            a.setPhoto(p);
            Category c = null;
            if (categoryId != 0) {
                c = new CategoryService().findCategory(categoryId);
            }
            a.setCategory(c);
        }
        
        addresses.add(a);
        return addresses;
    }
}
