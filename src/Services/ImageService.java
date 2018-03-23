package Services;

import Entities.Image;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ImageService extends Service {

    public Image findImage(int id){
        String sql = "SELECT * FROM photos WHERE id = "+ id ;
        Image i = null;
        try {
            Statement stm = this.connection.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next()){
                i = new Image();
                i.setId(rs.getInt("id"));
                i.setUrl(rs.getString("url"));
                i.setAlt(rs.getString("alt"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }
}
