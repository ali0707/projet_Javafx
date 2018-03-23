package Services;

import Core.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Service {

    protected Connection connection;

    public Service(){
        DBConnection dbc = DBConnection.getInstance();
        this.connection = dbc.getConnection();
    }

    public void deleteObject(int id, String tablename){
        String sql = "DELETE FROM " + tablename + " WHERE " + tablename + ".id = ?";
        try {
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Le " + tablename + " a été supprimé");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
