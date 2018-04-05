package Services;

import Entities.Music;
import Entities.Photo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class MusicService extends Service {

    public void addMusic(Music m){
        String sql =
                "INSERT INTO music (title, url, duration, singer, photo_id, alt) " +
                        "VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ps.setString(1, m.getTitle());
            ps.setString(2, m.getUrl());
            ps.setTime(3,new Time(m.getDuration()* 1000));
            ps.setString(4, m.getSinger());
            ps.setInt(5, m.getPhoto().getId());
            ps.setString(6, m.getAlt());
            ps.executeUpdate();
            System.out.println("Le music a été ajouté avec succes");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateMusic(Music m){
        String sql =
                "UPDATE music " +
                        "SET title=?, url=?,singer=?, photo_id=? , duration=?, alt=?"+
                        "WHERE music.id = ?";
        try {
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ps.setString(1, m.getTitle());
            ps.setString(2, m.getUrl());
            ps.setString(3, m.getSinger());
            ps.setInt(4, m.getPhoto().getId());
            ps.setTime(5, new Time(m.getDuration()));
            ps.executeUpdate();
            System.out.println("Le music a été modifié avec succes");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Music findMusic(int id){
        String sql = "SELECT * FROM music WHERE id = "+ id ;

        Music m = null;
        try {
            Statement stm = this.connection.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next()){
                m = new Music();
                m.setId(rs.getInt("id"));
                m.setTitle(rs.getString("title"));
                m.setUrl(rs.getString("url"));
                m.setSinger(rs.getString("singer"));
                int photoId = rs.getInt("photo_id");
                Photo p = null;
                if (photoId != 0){
                    p = new PhotoService().findImage(photoId);
                }
                m.setPhotoId(p);
                m.setDuration((int) rs.getTime("duration").getTime() / 1000);
                m.setAlt(rs.getString("alt"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return m;
    }

    public ObservableList<Music> findAll(){
        String sql = "SELECT * FROM music";
        return getList(sql);
    }


    public ObservableList<Music> findMusics(int id) {
        String sql = "SELECT * FROM music WHERE cartoon_id = " + id;
        return getList(sql);
    }

    private ObservableList<Music> getList(String sql) {
        ObservableList<Music> musics = FXCollections.observableArrayList();
        try {
            Statement stmt = this.connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                Music m = new Music();
                m.setId(rs.getInt("id"));
                m.setTitle(rs.getString("title"));
                m.setUrl(rs.getString("url"));
                m.setSinger(rs.getString("singer"));
                int photoId = rs.getInt("photo_id");
                Photo p = null;
                if (photoId != 0){
                    p = new PhotoService().findImage(photoId);
                }
                m.setPhotoId(p);
                m.setDuration((int) rs.getTime("duration").getTime() / 1000);
                m.setAlt(rs.getString("alt"));
                musics.add(m);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return musics;
    }

}
