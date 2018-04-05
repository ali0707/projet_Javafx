package Entities;

import java.sql.Time;
import java.util.Objects;

public class Music {

    private int id;
    private String title;
    private Integer duration;
    private String singer;
    private Photo photo;
    private String url;
    private String alt;

    public Music(String title, Integer duration, String singer, Photo photo, String url, String alt) {
        this.title = title;
        this.duration = duration;
        this.singer = singer;
        this.photo = photo;
        this.url = url;
        this.alt = alt;
    }

    public Music(int id, String title, Integer duration, String singer, Photo photo, String url, String alt) {
        this.id = id;
        this.title = title;
        this.duration = duration;
        this.singer = singer;
        this.photo = photo;
        this.url = url;
        this.alt = alt;
    }

    public Music() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }


    public Photo getPhoto() {
        return photo;
    }

    public void setPhotoId(Photo photo) {
        this.photo = photo;
    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Music that = (Music) o;
        return id == that.id &&
                Objects.equals(title, that.title) &&
                Objects.equals(duration, that.duration) &&
                Objects.equals(singer, that.singer) &&
                Objects.equals(photo, that.photo) &&
                Objects.equals(url, that.url) &&
                Objects.equals(alt, that.alt);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, title, duration, singer, photo, url, alt);
    }

    public String getWebPath() {
        return "C:/xampp/htdocs/PIDEV/web/uploads/music/" + title.replace(" ", "") + ".mp3";
    }
}
