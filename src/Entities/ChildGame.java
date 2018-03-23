package Entities;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Objects;

public class ChildGame {
    private int id;
    private Integer childId;
    private Integer gameId;
    private Timestamp date;
    private Time duration;


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


    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }


    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }


    public Time getDuration() {
        return duration;
    }

    public void setDuration(Time duration) {
        this.duration = duration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChildGame that = (ChildGame) o;
        return id == that.id &&
                Objects.equals(childId, that.childId) &&
                Objects.equals(gameId, that.gameId) &&
                Objects.equals(date, that.date) &&
                Objects.equals(duration, that.duration);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, childId, gameId, date, duration);
    }
}
