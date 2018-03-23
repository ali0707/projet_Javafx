package Services;

import Entities.Child;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ChildService extends Service {

    public void addChild(Child c){
        String sql =
                "INSERT INTO child (photo_id, name, age, parent_id, gender) " +
                        "VALUES (?,?,?,?,?)";
        try {
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ps.setInt(1, c.getPhotoId());
            ps.setString(2, c.getName());
            ps.setInt(3, c.getAge());
            ps.setInt(4, c.getPhotoId());
            ps.setBoolean(5, c.getGender());
            ps.executeUpdate();
            System.out.println("L'enfant a été ajouté avec succes");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateChild(Child c){
        String sql =
                "UPDATE child " +
                        "SET photo_id=?, name=?, age=?, gender=? , parent_id=?" +
                        "WHERE child.id = ?";
        try {
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ps.setInt(1, c.getPhotoId());
            ps.setString(2, c.getName());
            ps.setInt(3, c.getAge());
            ps.setBoolean(4, c.getGender());
            ps.setInt(5, c.getParentId());
            ps.setInt(6, c.getId());
            ps.executeUpdate();
            System.out.println("L'enfant a été modifié avec succes");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Child findChild(int id){
        String sql = "SELECT * FROM Child WHERE id = "+ id ;
        Child c = null;
        try {
            Statement stm = this.connection.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next()){
                c = new Child();
                c.setId(rs.getInt("id"));
                c.setAge(rs.getInt("age"));
                c.setName(rs.getString("name"));
                c.setGender(rs.getBoolean("gender"));
                c.setParentId(rs.getInt("parent_id"));
                c.setPhotoId(rs.getInt("photo_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return c;
    }

    public ObservableList<Child> findAll(){
        String sql = "SELECT * FROM Child";
        return getList(sql);
    }


    public ObservableList<Child> findMykids(int id) {
        String sql = "SELECT * FROM child WHERE parent_id = " + id;
        return getList(sql);
    }

    private ObservableList<Child> getList(String sql) {
        ObservableList<Child> kids = FXCollections.observableArrayList();
        try {
            Statement stmt = this.connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                Child c = new Child();
                c.setId(rs.getInt("id"));
                c.setAge(rs.getInt("age"));
                c.setName(rs.getString("name"));
                c.setGender(rs.getBoolean("gender"));
                c.setParentId(rs.getInt("parent_id"));
                c.setPhotoId(rs.getInt("photo_id"));
                kids.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return kids;
    }


}
