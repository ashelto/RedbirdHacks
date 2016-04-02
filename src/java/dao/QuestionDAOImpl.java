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
import model.Question;
import model.User;

/**
 *
 * @author billylim
 */
public class QuestionDAOImpl implements QuestionDAO {

    String driverName = "org.gjt.mm.mysql.Driver"; //"com.mysql.jdbc.Driver";
    String connStr = "jdbc:mysql://redbirdhacksquiz.ce72apzqt9s2.us-west-2.rds.amazonaws.com:3306/quiz";
    String user = "master";
    String password = "alpine102";

    @Override
    public int createQuestion(Question aQuestion) {
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
            String sqlStr = "INSERT INTO testQuestions (questionId, question, questionType, possibleAnswers, correctAnswer)"
                    + "VALUES (?,?,?,?,?,?)";
            PreparedStatement stmt = DBConn.prepareStatement(sqlStr);
            stmt.setInt(1, aQuestion.getQuestionId());
            stmt.setString(2, aQuestion.getQuestion());
            stmt.setString(3, aQuestion.getQuestionType());
            //stmt.setString(4, aQuestion.getPossibleAnswers()); // having these two commented out will cause errors!
            //stmt.setString(5, aQuestion.getCorrectAnswer());

            rowCount = stmt.executeUpdate();
            DBConn.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        // if insert is successful, rowCount will be set to 1 (1 row inserted successfully). Else, insert failed.
        return rowCount;
    }

  //  @Override
  //  public ArrayList findAll() {
  //      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  //  }
    

//    @Override
//    public boolean findUser(User aUser) {
//        Connection DBConn = null;
//        boolean result = false;
//        try {
//            DBHelper.loadDriver(driverName);
//            DBConn = DBHelper.connect2DB(connStr, user, password);
//
//            // With the connection made, create a statement to talk to the DB server.
//            // Create a SQL statement to query, retrieve the rows one by one (by going to the
//            // columns), and formulate the result string to send back to the client.
//            
//            String sqlStr = "SELECT * FROM Users WHERE username = ? and password = ?";
//            PreparedStatement stmt = DBConn.prepareStatement(sqlStr);
//            stmt.setString(1, aUser.getUsername());
//            stmt.setString(2, aUser.getPassword());
//            ResultSet rs = stmt.executeQuery();
//             //username,first,last,password,email,securityQ,securityA
//            if (rs.next()) {
//                result = true;
//                aUser.setUsername(rs.getString("username"));
//                aUser.setFirstName(rs.getString("firstName"));
//                aUser.setLastName(rs.getString("lastName"));
//                aUser.setPassword(rs.getString("password"));
//                aUser.setEmail(rs.getString("email"));
//                aUser.setRole(rs.getString("role"));
//            }
//            rs.close();
//            stmt.close();
//        } catch (Exception e) {
//            System.err.println("ERROR: Problems with SQL select");
//            e.printStackTrace();
//        }
//        try {
//            DBConn.close();
//        } catch (SQLException e) {
//            System.err.println(e.getMessage());
//        }
//        return result;
//    }
//    
//    @Override
//    public int updateUser(User aUser) {
//        try {
//            Class.forName(driverName);
//        } catch (ClassNotFoundException e) {
//            System.err.println(e.getMessage());
//            System.exit(0);
//        }

//        int rowCount = 0;
//        try {
//            
//            Connection DBConn = DriverManager.getConnection(connStr, user, password);
//             //username,first,last,password,email,securityQ,securityA
//            String sqlStr = "UPDATE Users SET "
//                    + "username = ?" + ","
//                    + "firstName = ?" + ","
//                    + "lastName = ?" + ","
//                    + "password = ?" + ","
//                    + "role = ?" + ","
//                    + "email = ?"
//                    + "WHERE username = ?";
//            PreparedStatement stmt = DBConn.prepareStatement(sqlStr);
//            stmt.setString(1, aUser.getUsername());
//            stmt.setString(2, aUser.getFirstName());
//            stmt.setString(3, aUser.getLastName());
//            stmt.setString(4, aUser.getPassword());
//            stmt.setString(5, aUser.getRole());
//            stmt.setString(6, aUser.getEmail());
//            stmt.setString(7, aUser.getUsername());
//            rowCount = stmt.executeUpdate();
//            DBConn.close();
//        } catch (SQLException e) {
//            System.err.println(e.getMessage());
//        }
//        // if insert is successful, rowCount will be set to 1 (1 row inserted successfully). Else, insert failed.
//        return rowCount;
//    }
//
}
