package Entities;

import java.util.Objects;

public class AttemptQuiz {
    
    private int attemptId;
    private int quizId;


    public int getAttemptId() {
        return attemptId;
    }

    public void setAttemptId(int attemptId) {
        this.attemptId = attemptId;
    }


    public int getQuizId() {
        return quizId;
    }

    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AttemptQuiz that = (AttemptQuiz) o;
        return attemptId == that.attemptId &&
                quizId == that.quizId;
    }

    @Override
    public int hashCode() {

        return Objects.hash(attemptId, quizId);
    }
}
