/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.QuizDAO;
import dao.QuizDAOImpl;
import javax.faces.bean.ManagedBean;
import model.Quiz;

/**
 *
 * @author Tom
 */
@ManagedBean
public class EditQuizController {
    private Quiz quiz;
    private int quizid;
    
    public EditQuizController() {
        //QuizDAO quizDAO = new QuizDAOImpl();
        //this.quiz = quizDAO.getQuizByID(8);        
    }

    public int getQuizid() {
        return quizid;
    }

    public void setQuizid(int quizid) {
        this.quizid = quizid;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }
    
    public void test() {
        QuizDAO quizDAO = new QuizDAOImpl();
        this.quiz = quizDAO.getQuizByID(quizid);
    }
}
