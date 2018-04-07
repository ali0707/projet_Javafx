package Services;

import Core.Exceptions.UserNotFoundException;
import Entities.Photo;
import Entities.User;
import Entities.UserInfos;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class UserService extends Service {

    public User findUser(int id){
        String sql = "SELECT * FROM user WHERE id = "+ id ;
        return getUser(sql);
    }

    public User findLogin(String login) throws UserNotFoundException {
        login = login.toLowerCase();
        String sql = "SELECT * FROM user WHERE ";
        if(login.matches("^[a-z]([a-z]|[0-9])*@[a-z].*\\.[a-z]*$"))
            sql += "email_canonical = '" + login + "'";
        else sql += "username_canonical = '"+ login + "'";
        User u = getUser(sql);
        if(u == null)
            throw new UserNotFoundException("Le nom d'utilisateur ou l'adresse email n'existe pas");
        return u;
    }

    private User getUser(String sql) {
        User u = null;
        try {
            Statement stm = this .connection.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next()){
                u = new User();
                u.setId(rs.getInt("id"));
                u.setEmail(rs.getString("email"));
                u.setEnabled(rs.getBoolean("enabled"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setSalt(rs.getString("salt"));
                u.setRoles(rs.getString("roles"));
                int infosId = rs.getInt("infos_id");
                UserInfos ui = null;
                if (infosId != 0)
                    ui = getUserInfos(infosId);
                u.setUserInfos(ui);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return u;
    }

    public void registerUser(User u) {
        String sql =
                "INSERT INTO user (username, username_canonical, email, email_canonical, " +
                        "enabled, salt, password, roles, last_login) " +
                        "VALUES (?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ps.setString(1, u.getUsername());
            ps.setString(2, u.getUsernameCanonical());
            ps.setString(3, u.getEmail());
            ps.setString(4, u.getEmailCanonical());
            ps.setBoolean(5, true);
            ps.setString(6, u.getSalt());
            ps.setString(7, u.getPassword());
            ps.setString(8,u.getRoles());
            java.util.Date current = new java.util.Date();
            ps.setDate(9, new Date(current.getTime()));
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ObservableList<User> findAll() {
        String sql = "SELECT * FROM user";
        ObservableList<User> users = FXCollections.observableArrayList();
        try {
            Statement stm = this.connection.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next()) {
                User u = new User();
                u.setId(rs.getInt("id"));
                u.setEmail(rs.getString("email"));
                u.setEnabled(rs.getBoolean("enabled"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setSalt(rs.getString("salt"));
                u.setRoles(rs.getString("roles"));
                u.setLastLogin(rs.getTimestamp("last_login"));
                int infosId = rs.getInt("infos_id");
                UserInfos ui = null;
                if(infosId != 0)
                    ui = getUserInfos(infosId);
                u.setUserInfos(ui);
                users.add(u);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    private UserInfos getUserInfos(int infosId) throws SQLException {
        UserInfos ui = new UserInfos();
        Statement stm = this.connection.createStatement();
        ResultSet rs = stm.executeQuery("SELECT * FROM user_infos WHERE id = " + infosId);
        while (rs.next()) {
            ui = new UserInfos();
            ui.setId(infosId);
            ui.setFirstname(rs.getString("firstname"));
            ui.setLastname(rs.getString("lastname"));
            ui.setPhone(rs.getInt("phone"));
            ui.setRegion("region");
            int photoId = rs.getInt("photo_id");
            Photo p = null;
            if (photoId != 0) {
                p = new PhotoService().findImage(photoId);
            }
            ui.setPhoto(p);
        }
        return ui;
    }
}
