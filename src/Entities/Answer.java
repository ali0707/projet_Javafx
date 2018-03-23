package Entities;

import java.util.Objects;

public class Answer {

    private int id;
    private Integer questionId;
    private String content;
    private boolean correct;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    
    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    
    
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    
    
    public boolean getCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Answer that = (Answer) o;
        return id == that.id &&
                correct == that.correct &&
                Objects.equals(questionId, that.questionId) &&
                Objects.equals(content, that.content);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, questionId, content, correct);
    }

}
