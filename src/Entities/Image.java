package Entities;

import java.util.Objects;

public class Image {

    public Image(String url, String alt) {
        this.url = url;
        this.alt = alt;
    }

    public Image(int id, String url, String alt) {
        this.id = id;
        this.url = url;
        this.alt = alt;
    }

    private int id;
    private String url;
    private String alt;

    public Image() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        Image that = (Image) o;
        return id == that.id &&
                Objects.equals(url, that.url) &&
                Objects.equals(alt, that.alt);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, url, alt);
    }

    public String getWebPath(){
        return "file:C:/xampp/htdocs/PIDEV/web/uploads/img/" + id + '.' +  url;
    }
}