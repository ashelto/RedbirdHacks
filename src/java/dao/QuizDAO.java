/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import model.Quiz;

/**
 *
 * @author Tom
 */
public interface QuizDAO {
    public int createQuiz(Quiz quiz);
    public Quiz getQuizByID(int quizID);
    public ArrayList<Quiz> getAllQuizzes();
    public ArrayList<Quiz> getAllProfQuizzes(String profUsername);
}
