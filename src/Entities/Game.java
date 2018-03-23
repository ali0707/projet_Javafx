package Entities;

import java.util.Objects;

public class Game {

    private int id;
    private Integer iconId;
    private String name;
    private String url;
    private int age;
    private String device;
    private Integer categoryId;
    private int gender;

    public Game(){

    }

    public Game(Integer iconId, String name, String url, int age, String device, Integer categoryId, int gender) {
        this.iconId = iconId;
        this.name = name;
        this.url = url;
        this.age = age;
        this.device = device;
        this.categoryId = categoryId;
        this.gender = gender;
    }

    public Game(int id, Integer iconId, String name, String url, int age, String device, Integer categoryId, int gender) {
        this.id = id;
        this.iconId = iconId;
        this.name = name;
        this.url = url;
        this.age = age;
        this.device = device;
        this.categoryId = categoryId;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Integer getIconId() {
        return iconId;
    }

    public void setIconId(Integer iconId) {
        this.iconId = iconId;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }


    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }


    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game that = (Game) o;
        return id == that.id &&
                age == that.age &&
                gender == that.gender &&
                Objects.equals(iconId, that.iconId) &&
                Objects.equals(name, that.name) &&
                Objects.equals(url, that.url) &&
                Objects.equals(device, that.device) &&
                Objects.equals(categoryId, that.categoryId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, iconId, name, url, age, device, categoryId, gender);
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", iconId=" + iconId +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", age=" + age +
                ", device='" + device + '\'' +
                ", categoryId=" + categoryId +
                ", gender=" + gender +
                '}';
    }
}
