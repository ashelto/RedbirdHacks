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
import java.sql.Statement;
import java.util.ArrayList;
import model.Answer;
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
        int newQuizID = 0;
        try {          
            Connection DBConn = DriverManager.getConnection(connStr, user, password);
            
            //username,first,last,password,email,securityQ,securityA
            String sqlStr = "INSERT INTO Quizzes (profUsername, quizTitle) VALUES (?,?)";
            PreparedStatement stmt = DBConn.prepareStatement(sqlStr, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, quiz.getAuthor()); // update to insert professor's username
            stmt.setString(2, quiz.getName());
            rowCount = stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()){
                newQuizID = rs.getInt(1);
            }
            DBConn.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        // if insert is successful, rowCount will be set to 1 (1 row inserted successfully). Else, insert failed.
        return newQuizID;
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
                Question question = new Question();
                PreparedStatement answerStmt;
                ResultSet answerRS;
                while (questionRS.next()) {
                    question = new Question();
                    question.setQuestionId(questionRS.getInt(1));
                    question.setQuestionText(questionRS.getString(2));
                    question.setQuestionType(questionRS.getString(3));
                    answerStmt = DBConn.prepareStatement("SELECT * FROM Answers where questionID=?");
                    answerStmt.setInt(1, question.getQuestionId());
                    answerRS = answerStmt.executeQuery();
                        while(answerRS.next()) {
                            question.getAnswers().add(new Answer(answerRS.getInt(1), answerRS.getString(2), answerRS.getBoolean(3)));
                        }
                    System.out.println(question.getQuestion());
                    quiz.getQuestionSet().add(question);
                }
            }
            
            DBConn.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        // if insert is successful, rowCount will be set to 1 (1 row inserted successfully). Else, insert failed.
        return quiz;
    }

    @Override
    public ArrayList<Quiz> getAllQuizzes() {
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }   
        
        ArrayList<Quiz> quizzes = new ArrayList<>();
        try {          
            Connection DBConn = DriverManager.getConnection(connStr, user, password);

            //username,first,last,password,email,securityQ,securityA
            String sqlStr = "SELECT * FROM Quizzes";
            PreparedStatement quizStmt = DBConn.prepareStatement(sqlStr);
            ResultSet quizRS = quizStmt.executeQuery();
            
            Quiz quiz;
            while(quizRS.next()){
                quiz = new Quiz();
                
                quiz.setQuizId(quizRS.getInt(1));
                quiz.setAuthor(quizRS.getString(2));
                quiz.setName(quizRS.getString(3));
                
                quizzes.add(quiz);
            }
            
            DBConn.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        
        return quizzes;
    }

    @Override
    public ArrayList<Quiz> getAllProfQuizzes(String profUsername) {
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }   
        
        ArrayList<Quiz> quizzes = new ArrayList<>();
        try {          
            Connection DBConn = DriverManager.getConnection(connStr, user, password);

            //username,first,last,password,email,securityQ,securityA
            String sqlStr = "SELECT * FROM Quizzes WHERE profUsername=?";
            PreparedStatement quizStmt = DBConn.prepareStatement(sqlStr);
            quizStmt.setString(1, profUsername);
            ResultSet quizRS = quizStmt.executeQuery();
            
            Quiz quiz;
            while(quizRS.next()){
                quiz = new Quiz();
                
                quiz.setQuizId(quizRS.getInt(1));
                quiz.setAuthor(quizRS.getString(2));
                quiz.setName(quizRS.getString(3));
                
                quizzes.add(quiz);
            }
            
            DBConn.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        
        return quizzes;
    }
    
}
