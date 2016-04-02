/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Tom
 */
public class Answer {
    private int questionID;
    private String answer;
    private boolean correct;

    public Answer() {
    }

    public Answer(int questionID, String answer, boolean correct) {
        this.questionID = questionID;
        this.answer = answer;
        this.correct = correct;
    }
    
    public int getQuestionID() {
        return questionID;
    }

    public void setQuestionID(int questionID) {
        this.questionID = questionID;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }
}
