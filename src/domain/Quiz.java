package domain;

/**
 * Created by xmen_alive on 7/24/17.
 */
public class Quiz {
    String correct;
    String question;
    String clicked;
    int qId;
    int uid;
    int marks;

    public void setqId(int qId) {
        this.qId = qId;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public int getqId() {
        return qId;
    }

    public String getCorrect() {
        return correct;
    }

    public void setCorrect(String correct) {
        this.correct = correct;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getClicked() {
        return clicked;
    }

    public void setClicked(String clicked) {
        this.clicked = clicked;
    }



}
