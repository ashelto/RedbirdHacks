/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
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
//    public boolean validateAnswer()
//    {
//        boolean correct;
//        if(userResponse.equals(quizModel.))
//    }
    
}
