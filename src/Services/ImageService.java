package Services;

import Entities.Photo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ImageService extends Service {

    public Photo findImage(int id){
        String sql = "SELECT * FROM photos WHERE id = "+ id ;
        Photo i = null;
        try {
            Statement stm = this.connection.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next()){
                i = new Photo();
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
