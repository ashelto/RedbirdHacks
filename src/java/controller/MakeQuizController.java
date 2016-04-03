/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.QuizDAO;
import dao.QuizDAOImpl;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
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
        int newQuizID = quizDAO.createQuiz(quiz);
         if (newQuizID > 0) {
             return ("/profView.xhtml?faces-redirect=true");
         } else {
            return "";
         }
    }

    public static String encodeURIComponent(String component)   {     
	String result = null;      
	
	try {       
		result = URLEncoder.encode(component, "UTF-8")   
			   .replaceAll("\\%28", "(")                          
			   .replaceAll("\\%29", ")")   		
			   .replaceAll("\\+", "%20")                          
			   .replaceAll("\\%27", "'")   			   
			   .replaceAll("\\%21", "!")
			   .replaceAll("\\%7E", "~");     
        } catch (UnsupportedEncodingException e) {       
		result = component;     
	}      
	
	return result;   
}  
}
