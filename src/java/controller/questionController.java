/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.QuestionDAO;
import dao.QuestionDAOImpl;
import dao.QuizDAO;
import dao.QuizDAOImpl;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import model.Question;
import model.Quiz;
import model.User;

/**
 *
 * @author it3530218
 */
@ManagedBean

public class questionController 
{
    @ManagedProperty(value="#{loginController.theModel}")
    private User theModel;
    private Quiz quizModel;
    private Question question;
    private String[] type = {"Select Question", "Multiple Choice","True/False","Fill in the blank"};

    public questionController() {
          question = new Question();
          quizModel = new Quiz();
    }

    public String[] getType() {
        return type;
    }
    /**
     * @param type the type to set
     */
    public void setType(String[] type) {
        this.type = type;
    }

    /**
     * @return the theModel
     */
    public User getTheModel() {
        return theModel;
    }

    /**
     * @param theModel the theModel to set
     */
    public void setTheModel(User theModel) {
        this.theModel = theModel;
    }

    /**
     * @return the quiz
     */
    public Quiz getQuizModel() {
        return quizModel;
    }

    /**
     * @param quizModel the quiz to set
     */
    public void setQuizModel(Quiz quizModel) {
        this.quizModel = quizModel;
    }

    /**
     * @return the question
     */
    public Question getQuestion() {
        return question;
    }

    /**
     * @param question the question to set
     */
    public void setQuestion(Question question) {
        this.question = question;
    }
        
    public void prerenderSetup() {
        QuizDAO quizDAO = new QuizDAOImpl();
        quizModel = quizDAO.getQuizByID(quizModel.getQuizId());
    }
    
    public String createQuestion()
    {
        QuestionDAO aQuestionDAO = new QuestionDAOImpl();
        int aQuestion = aQuestionDAO.createQuestion(question, quizModel.getQuizId());
        
        if(aQuestion ==1)
        {
            return "/createQuestion.xhtml?quizId=" + quizModel.getQuizId();
        }
        else
        {
            return "";
        }
    }
      
}     