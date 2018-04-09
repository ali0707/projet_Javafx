package Entities;

import java.util.Objects;

public class Teacher {
    private int id;
    private String name;
    private String lastname;
    private double price;
    private String account;
    private int phone;
    private String degree;
    private String experience;
    private String hobbies;
    private Photo photo;
    private Subject subject;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getHobbies() {
        return hobbies;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher that = (Teacher) o;
        return id == that.id &&
                Double.compare(that.price, price) == 0 &&
                phone == that.phone &&
                Objects.equals(subject, that.subject) &&
                Objects.equals(photo, that.photo) &&
                Objects.equals(name, that.name) &&
                Objects.equals(account, that.account) &&
                Objects.equals(lastname, that.lastname) &&
                Objects.equals(degree, that.degree) &&
                Objects.equals(experience, that.experience) &&
                Objects.equals(hobbies, that.hobbies);
    }

    public int hashCode() {

        return Objects.hash(id, subject, photo, price, name, account, phone, lastname, degree, experience, hobbies);
    }
}
