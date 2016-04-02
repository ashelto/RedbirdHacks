/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.QuizDAO;
import dao.QuizDAOImpl;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import model.Quiz;
import model.User;

/**
 *
 * @author Tom
 */
@ManagedBean
public class MakeQuizController {
    private Quiz quiz;
    
    @ManagedProperty(value="#{loginController.theModel}")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }    

    public MakeQuizController() {
        quiz = new Quiz();
    }  

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }
    
    public String createQuiz() {
        QuizDAO quizDAO = new QuizDAOImpl();
        quiz.setAuthor(user.getUsername());
         if (quizDAO.createQuiz(quiz) == 1) {
             //return "editquiz?quizid=" + id;
         }
         return "";
    }
    
    
}
