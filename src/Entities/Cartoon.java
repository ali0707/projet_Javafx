package Entities;


import java.util.Objects;

public class Cartoon {

    private int id;
    private Photo photo;
    private String summary;
    private int episodesCnt;
    private int age;
    private int gender;
    private String name;

    public Cartoon(Photo photo, String summary, int episodesCnt, int age, int gender, String name) {
        this.photo = photo;
        this.summary = summary;
        this.episodesCnt = episodesCnt;
        this.age = age;
        this.gender = gender;
        this.name = name;
    }

    public Cartoon(int id, Photo photo, String summary, int episodesCnt, int age, int gender, String name) {
        this.id = id;
        this.photo = photo;
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

    
    
    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
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
                Objects.equals(photo, that.photo) &&
                Objects.equals(summary, that.summary) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, photo, summary, episodesCnt, age, gender, name);
    }

    @Override
    public String toString() {
        return "Cartoon{" +
                "id=" + id +
                ", photo=" + photo +
                ", summary='" + summary + '\'' +
                ", episodesCnt=" + episodesCnt +
                ", age=" + age +
                ", gender=" + gender +
                ", name='" + name + '\'' +
                '}';
    }
}
