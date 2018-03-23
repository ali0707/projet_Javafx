package Entities;

import java.util.Objects;

public class AnswerChild {
    
    private int answerId;
    private int childId;

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }



    public int getChildId() {
        return childId;
    }

    public void setChildId(int childId) {
        this.childId = childId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnswerChild that = (AnswerChild) o;
        return answerId == that.answerId &&
                childId == that.childId;
    }

    @Override
    public int hashCode() {

        return Objects.hash(answerId, childId);
    }

}
