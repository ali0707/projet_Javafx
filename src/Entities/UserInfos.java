package Entities;

import java.util.Objects;

public class UserInfos {

    private int id;
    private String firstname;
    private String lastname;
    private int phone;
    private String region;
    private Integer photoId;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }


    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }


    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }


    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }


    public Integer getPhotoId() {
        return photoId;
    }

    public void setPhotoId(Integer photoId) {
        this.photoId = photoId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserInfos that = (UserInfos) o;
        return id == that.id &&
                phone == that.phone &&
                Objects.equals(firstname, that.firstname) &&
                Objects.equals(lastname, that.lastname) &&
                Objects.equals(region, that.region) &&
                Objects.equals(photoId, that.photoId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, firstname, lastname, phone, region, photoId);
    }
}
