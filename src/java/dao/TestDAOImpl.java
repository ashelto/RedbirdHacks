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

/**
 *
 * @author Tom
 */
public class TestDAOImpl {
    String driverName = "org.gjt.mm.mysql.Driver"; //"com.mysql.jdbc.Driver";
    String connStr = "jdbc:mysql://redbirdhacksquiz.ce72apzqt9s2.us-west-2.rds.amazonaws.com:3306/quiz";
    
    public int test() {
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            System.err.println("test1 ERROR: " + e.getMessage());
            System.exit(0);
        }

        int rowCount = -1;
        try {
            
            Connection DBConn = DriverManager.getConnection(connStr, "master", "alpine102");

            //username,first,last,password,email,securityQ,securityA
            String sqlStr = "SELECT * FROM new_table";
            PreparedStatement stmt = DBConn.prepareStatement(sqlStr);
            ResultSet rs = stmt.executeQuery(sqlStr);
            rowCount = rs.getRow();
            DBConn.close();
        } catch (SQLException e) {
            System.err.println("test2 ERROR: " + e.getMessage());
        }

        // if insert is successful, rowCount will be set to 1 (1 row inserted successfully). Else, insert failed.
        return rowCount;
    }
}
