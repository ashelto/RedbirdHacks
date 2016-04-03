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
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import model.Quiz;
import model.User;

/**
 *
 * @author Tom
 */
@ManagedBean
@SessionScoped
public class AssignmentController {
    private ArrayList<Quiz> quizzes = new ArrayList<>();
    
    @ManagedProperty(value="#{loginController.theModel}")
    private User user;
    
    public AssignmentController() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ArrayList<Quiz> getQuizzes() {
        return quizzes;
    }

    public void setQuizzes(ArrayList<Quiz> quizzes) {
        this.quizzes = quizzes;
    }
    
    public void loadQuizzes() {
        QuizDAO quizDAO = new QuizDAOImpl();
        quizzes = quizDAO.getAllQuizzes();
    }
    
    public void loadProfQuizzes() {
        QuizDAO quizDAO = new QuizDAOImpl();
        quizzes = quizDAO.getAllProfQuizzes(user.getUsername());
    }
    
    public String redirect() {
        int quizID = 8;
        System.out.println("redirect method: " + quizID);
        return "/quizconfirm.xhtml";
    }
}
