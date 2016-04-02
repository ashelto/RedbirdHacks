/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author it3530218
 */
public class Question 
{
    private String questionId;
    private String question;
    private String questionType;
    private String possibleAnswers;
    private String correctAnswer; 

    public Question() 
    {
        
    }

    public Question(String questionId,String question, String questionType, String possibleAnswers, String correctAnswer) 
    {
        this.questionId = questionId;
        this.question = question;
        this.questionType = questionType;
        this.possibleAnswers = possibleAnswers;
        this.correctAnswer = correctAnswer;
    }
    
    /**
     * @return the questionId
     */
    public String getQuestionId() {
        return questionId;
    }

    /**
     * @param questionId the questionId to set
     */
    public void setQuestionId(String questionId) {
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

    /**
     * @return the possibleAnswers
     */
    public String getPossibleAnswers() {
        return possibleAnswers;
    }

    /**
     * @param possibleAnswers the possibleAnswers to set
     */
    public void setPossibleAnswers(String possibleAnswers) {
        this.possibleAnswers = possibleAnswers;
    }

    /**
     * @return the correctAnswer
     */
    public String getCorrectAnswer() {
        return correctAnswer;
    }

    /**
     * @param correctAnswer the correctAnswer to set
     */
    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
    
    


}
