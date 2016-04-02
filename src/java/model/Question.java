/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author it3530218
 */
public class Question 
{
    private int questionId;
    private String question;
    private String questionType;
    private ArrayList<Answer> answers = new ArrayList<Answer>();

    public Question() {
    }

    public ArrayList<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(ArrayList<Answer> answers) {
        this.answers = answers;
    }
     
    /**
     * @return the questionId
     */
    public int getQuestionId() {
        return questionId;
    }

    /**
     * @param questionId the questionId to set
     */
    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    /**
     * @return the question
     */
    public String getQuestion() {
        return question;
    }

    /**
     * @param question the question to set
     */
    public void setQuestion(String question) {
        this.question = question;
    }

    /**
     * @return the type
     */
    public String getQuestionType() {
        return questionType;
    }

    /**
     * @param type the type to set
     */
    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }    
}
