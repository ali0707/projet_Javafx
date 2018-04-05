package Entities;

import java.sql.Date;
import java.sql.Time;
import java.util.Objects;

public class ChildGame {
    private int id;
    private Integer childId;
    private Game game;
    private Date date;
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


    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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
                Objects.equals(game, that.game) &&
                Objects.equals(date, that.date) &&
                Objects.equals(duration, that.duration);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, childId, game, date, duration);
    }
}
