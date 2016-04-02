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
public class Quiz 
{
    private int quizId;
    private String author;
    private String name;
    private String subject; 
    private int questions; 
    private ArrayList <Question> questionSet;

    public Quiz() {
    }

    public int getQuizId() {
        return quizId;
    }

    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getQuestions() {
        return questions;
    }

    public void setQuestions(int questions) {
        this.questions = questions;
    }

    public ArrayList<Question> getQuestionSet() {
        return questionSet;
    }

    public void setQuestionSet(ArrayList<Question> questionSet) {
        this.questionSet = questionSet;
    }
    
    
}
