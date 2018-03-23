package Entities;

import java.util.Objects;

public class Quiz {
    private int id;
    private Integer categoryId;
    private String name;
    private int difficulty;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quiz that = (Quiz) o;
        return id == that.id &&
                difficulty == that.difficulty &&
                Objects.equals(categoryId, that.categoryId) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, categoryId, name, difficulty);
    }
}
