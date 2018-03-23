package Entities;

import java.sql.Timestamp;
import java.util.Objects;

public class Attempt {
    private int id;
    private Integer childId;
    private Timestamp date;
    private int score;
    private Integer quizId;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Integer getChildId() {
        return childId;
    }

    public void setChildId(Integer childId) {
        this.childId = childId;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }


    public Integer getQuizId() {
        return quizId;
    }

    public void setQuizId(Integer quizId) {
        this.quizId = quizId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Attempt that = (Attempt) o;
        return id == that.id &&
                score == that.score &&
                Objects.equals(childId, that.childId) &&
                Objects.equals(date, that.date) &&
                Objects.equals(quizId, that.quizId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, childId, date, score, quizId);
    }
}
