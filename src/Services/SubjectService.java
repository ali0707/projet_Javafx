/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Photo;
import Entities.Subject;
import Entities.Subject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
/**
 *
 * @author ali
 */
public class SubjectService extends Service {

    public void addSubject( Subject s ){
        String req="INSERT INTO `subject`( name, description) " +
                "VALUES (?,?)";
        try {
            PreparedStatement pst = this.connection.prepareStatement(req);
            pst.setString(1,s.getName());
            pst.setString(2, s.getDescription());
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Subject findSubject(int id){
        String sql = "SELECT * FROM subject WHERE id = "+ id ;
        Subject s = null;
        try {
            Statement stm = this.connection.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next()){
                s = new Subject();
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setDescription(rs.getString("description"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return s;
    }

    public ObservableList <Subject> findAll(){
        String sql = "SELECT * FROM subject";
        ObservableList <Subject> subjects = FXCollections.observableArrayList();
        try {
            Integer photoId = 0;
            PreparedStatement prs = this.connection.prepareStatement(sql);
            ResultSet rs = prs.executeQuery();
            while (rs.next()) {
                Subject c = new Subject();
                c.setId(rs.getInt("id"));
                c.setName(rs.getString("name"));
                c.setDescription(rs.getString("description"));
                subjects.add(c);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return subjects;
    }
}
