package Services;

import Entities.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserService extends Service {

    public User findUser(int id){
        String sql = "SELECT * FROM user WHERE id = "+ id ;
        User u = null;
        try {
            Statement stm = this.connection.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next()){
                u = new User();
                u.setId(rs.getInt("id"));
                u.setEmail(rs.getString("email"));
                u.setEnabled(rs.getBoolean("enabled"));
                u.setUsername(rs.getString("username"));
                u.setRoles(rs.getString("roles"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return u;
    }

}
