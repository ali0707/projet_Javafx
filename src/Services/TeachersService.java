/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Photo;
import Entities.Subject;
import Entities.Teacher;
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
public class TeachersService extends Service {

    public void addTeacher( Teacher t ){
        String req="INSERT INTO `teacher`(`subject_id`, `photo_id`, `price`, `name`, `degree`, `experience`, `hobbies`, `account`, `phone`, `lastname`) " +
                "VALUES (?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement pst = null;
        try {
            pst = this.connection.prepareStatement(req);
            pst.setInt(1,t.getSubject().getId() );
            pst.setInt(2, t.getPhoto().getId());
            pst.setDouble(3, t.getPrice());
            pst.setString(4, t.getName());
            pst.setString(5, t.getDegree());
            pst.setString(6,t.getAccount());
            pst.setString(7, t.getHobbies());
            pst.setString(7, t.getAccount());
            pst.setInt(7, t.getPhone());
            pst.setString(7, t.getLastname());
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Teacher findteacher(int id){
        String sql = "SELECT * FROM teacher WHERE id = "+ id ;
        Integer photoId=null;
        Teacher t = null;
        try {
            Statement stm = this.connection.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next()){
                t = new Teacher();
                t.setId(rs.getInt("id"));
                t.setPrice(rs.getFloat("price"));
                t.setName(rs.getString("Name"));
                t.setDegree(rs.getString("degree"));
                t.setDegree(rs.getString("account"));
                t.setAccount(rs.getString("address"));
                t.setHobbies(rs.getString("hobbies"));
                t.setLastname(rs.getString("Lastename"));
                t.setPhone(rs.getInt("phone"));
                int subjectId = rs.getInt("subject_id");
                photoId = rs.getInt("photo_id");

                Photo p = null;
                if (photoId != 0){
                    p = new PhotoService().findImage(photoId);
                }
                t.setPhoto(p);

                Subject s = null;
                if (subjectId != 0){
                    s = new SubjectService().findSubject(subjectId);
                }
                t.setSubject(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return t;
    }

    public ObservableList <Teacher> findAll(){
        String sql = "SELECT * FROM teacher";
        ObservableList <Teacher> teachers = FXCollections.observableArrayList();
        try {
            Integer photoId = 0;
            PreparedStatement prs = this.connection.prepareStatement(sql);
            ResultSet rs = prs.executeQuery();
            while (rs.next()) {
                Teacher c = new Teacher();
                c.setId(rs.getInt("id"));
                c.setPrice(rs.getFloat("price"));
                c.setName(rs.getString("Name"));
                c.setDegree(rs.getString("degree"));
                c.setAccount(rs.getString("account"));
                c.setHobbies(rs.getString("hobbies"));
                c.setLastname(rs.getString("Lastname"));
                c.setPhone(rs.getInt("phone"));
                int subjectId = rs.getInt("subject_id");
                photoId = rs.getInt("photo_id");
                Photo p = null;
                Subject s =null;
                if (photoId != 0) {
                    p = new PhotoService().findImage(photoId);
                }
                if (subjectId != 0) {
                    s = new SubjectService().findSubject(subjectId);
                }
                c.setPhoto(p);
                c.setSubject(s);
                teachers.add(c);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return teachers;
    }
}
