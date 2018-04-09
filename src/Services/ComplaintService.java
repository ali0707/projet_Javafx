/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Article;
import Entities.Category;
import Entities.Complaint;
import Entities.Photo;
import Entities.User;
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
public class ComplaintService extends Service{
    public void addComplaint( Complaint complaint ) throws SQLException
    {
    String req ="INSERT INTO `complaint`(`user_id`,`category`, `description`, `subject`, `date`, `state`) values (?,?,?,?,?,?)";
        
        PreparedStatement pst = this.connection.prepareStatement(req);
        
      
        pst.setInt(1, complaint.getParent().getId());
        pst.setInt(2, complaint.getCategory().getId());
        pst.setString(3, complaint.getDescription());
        pst.setString(4, complaint.getSubject());
        pst.setDate(5,complaint.getDate());
        pst.setString(6,complaint.getState());
        
        pst.executeUpdate();
        System.out.println("ajouté bb");
    }
    public ObservableList <Complaint> findByUser(int user)
    {    ObservableList<Complaint> complaints = FXCollections.observableArrayList(); 
        try {
       
        String sql = "SELECT * FROM complaint WHERE user_id = "+ user ;
        Complaint c = null;
        Integer parentId= null; 
        Integer categoryId=null;
        Statement stm = this.connection.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        while(rs.next()){
            c = new Complaint();
            c.setId(rs.getInt("id"));
            c.setDescription(rs.getString("description"));
            c.setDate(rs.getDate("date"));
            c.setState(rs.getString("state"));
            c.setSubject(rs.getString("subject"));
            parentId = rs.getInt("user_id");
            categoryId=rs.getInt("category");
            
            User p = null;
            if (parentId != 0) {
                p = new UserService().findUser(parentId);
            }
            c.setParent(p);
            
            Category ca = null;
            if (categoryId != 0) {
                ca = new CategoryService().findCategory(categoryId);
            }
            c.setCategory(ca);
            complaints.add(c);
        }
        
        
        } catch (SQLException ex) {
            Logger.getLogger(ComplaintService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return complaints;
    }
}
