/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.QuizDAO;
import dao.QuizDAOImpl;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.Answer;
import model.Question;
import model.Quiz;

/**
 *
 * @author it3530117
 */
@ManagedBean
@SessionScoped
public class TakeQuizController {

    /**
     * Creates a new instance of TakeQuizController
     */
    Quiz quizModel;
    String userResponse;
    
    public TakeQuizController() {
        quizModel = new Quiz();
    }

    public Quiz getQuizModel() {
        return quizModel;
    }

    public void setQuizModel(Quiz quizModel) {
        this.quizModel = quizModel;
    }

    public String getUserResponse() {
        return userResponse;
    }

    public void setUserResponse(String userResponse) {
        this.userResponse = userResponse;
    }
    
    public void prerenderSetup() {
        QuizDAO quizDAO = new QuizDAOImpl();
        quizModel = quizDAO.getQuizByID(quizModel.getQuizId());
    }
    
    public String launchQuiz() {
        String questionType = quizModel.getQuestionSet().get(0).getQuestionType();
        if (questionType.equals("MC")) {
            return "/multipleChoiceView.xhtml";
        } else if (questionType.equals("TF")) {
            return "/trueFalseView.xhtml";
        } else if (questionType.equals("FITB")) {
            return "/fillinTheBlankView.xhtml"; 
        } else {
            System.out.println("ERROR: launchQuiz");
        }
        return "";
    }
    
    public String nextQuestion() {
        return null;
    }
}