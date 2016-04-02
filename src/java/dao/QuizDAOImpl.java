/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Question;
import model.Quiz;

/**
 *
 * @author Tom
 */
public class QuizDAOImpl implements QuizDAO {
    String driverName = "org.gjt.mm.mysql.Driver"; //"com.mysql.jdbc.Driver";
    String connStr = "jdbc:mysql://redbirdhacksquiz.ce72apzqt9s2.us-west-2.rds.amazonaws.com:3306/quiz";
    String user = "master";
    String password = "alpine102";
    
    @Override
    public int createQuiz(Quiz quiz) {
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }

        int rowCount = 0;
        try {          
            Connection DBConn = DriverManager.getConnection(connStr, user, password);

            //username,first,last,password,email,securityQ,securityA
            String sqlStr = "INSERT INTO Quizzes (profUsername, quizTitle) VALUES (?,?)";
            PreparedStatement stmt = DBConn.prepareStatement(sqlStr);
            stmt.setString(1, quiz.getAuthor()); // update to insert professor's username
            stmt.setString(2, quiz.getName());
            rowCount = stmt.executeUpdate();
            DBConn.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        // if insert is successful, rowCount will be set to 1 (1 row inserted successfully). Else, insert failed.
        return rowCount;
    }

    @Override
    public Quiz getQuizByID(int quizID) {
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }

        Quiz quiz = new Quiz();
        try {          
            Connection DBConn = DriverManager.getConnection(connStr, user, password);

            //username,first,last,password,email,securityQ,securityA
            String sqlStr = "SELECT * FROM Quizzes WHERE quizID=?";
            PreparedStatement quizStmt = DBConn.prepareStatement(sqlStr);
            quizStmt.setInt(1, quizID);
            ResultSet quizRS = quizStmt.executeQuery();
           
            if(quizRS.next()){
                // Set metadata of quiz
                quiz.setQuizId(quizRS.getInt(1));
                quiz.setAuthor(quizRS.getString(2));
                quiz.setName(quizRS.getString(3));
                
                // Get all questions for the quiz
                sqlStr = "SELECT * FROM Questions WHERE quizID=?";
                PreparedStatement questionStmt = DBConn.prepareStatement(sqlStr);
                questionStmt.setInt(1, quizID);
                ResultSet questionRS = questionStmt.executeQuery();
                int i = 0; // question index counter
                Question question = new Question();
                while (questionRS.next()) {
                    question.setQuestionId(questionRS.getInt(1));
                    question.setQuestion(questionRS.getString(2));
                    question.setQuestionType(questionRS.getString(3));                    
                }
                
            }
            
            DBConn.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        // if insert is successful, rowCount will be set to 1 (1 row inserted successfully). Else, insert failed.
        return quiz;
    }
    
}