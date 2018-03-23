package Entities;


import java.util.Objects;

public class Cartoon {

    private int id;
    private Integer photoId;
    private String summary;
    private int episodesCnt;
    private int age;
    private int gender;
    private String name;

    public Cartoon(Integer photoId, String summary, int episodesCnt, int age, int gender, String name) {
        this.photoId = photoId;
        this.summary = summary;
        this.episodesCnt = episodesCnt;
        this.age = age;
        this.gender = gender;
        this.name = name;
    }

    public Cartoon(int id, Integer photoId, String summary, int episodesCnt, int age, int gender, String name) {
        this.id = id;
        this.photoId = photoId;
        this.summary = summary;
        this.episodesCnt = episodesCnt;
        this.age = age;
        this.gender = gender;
        this.name = name;
    }

    public Cartoon() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    
    public Integer getPhotoId() {
        return photoId;
    }

    public void setPhotoId(Integer photoId) {
        this.photoId = photoId;
    }

    
    
    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    
    
    public int getEpisodesCnt() {
        return episodesCnt;
    }

    public void setEpisodesCnt(int episodesCnt) {
        this.episodesCnt = episodesCnt;
    }

    
    
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    
    
    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cartoon that = (Cartoon) o;
        return id == that.id &&
                episodesCnt == that.episodesCnt &&
                age == that.age &&
                gender == that.gender &&
                Objects.equals(photoId, that.photoId) &&
                Objects.equals(summary, that.summary) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, photoId, summary, episodesCnt, age, gender, name);
    }

    @Override
    public String toString() {
        return "Cartoon{" +
                "id=" + id +
                ", photoId=" + photoId +
                ", summary='" + summary + '\'' +
                ", episodesCnt=" + episodesCnt +
                ", age=" + age +
                ", gender=" + gender +
                ", name='" + name + '\'' +
                '}';
    }
}
