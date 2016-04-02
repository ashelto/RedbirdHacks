/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.TestDAOImpl;
import dao.UserDAO;
import dao.UserDAOImpl;

/**
 *
 * @author billylim
 */
public class User {
    
    private String username;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private String role;

    public User() {
    }  

    public User(String username, String firstName, String lastName, String password, String email, String role) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    
    
    /**
     * Get the value of password
     *
     * @return the value of password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set the value of password
     *
     * @param password new value of password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Get the value of username
     *
     * @return the value of username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Set the value of username
     *
     * @param username new value of username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public boolean isValidUser () {
        UserDAO aUSerDAO = new UserDAOImpl();
        boolean userAuthenticated = aUSerDAO.findUser(this);      
        return userAuthenticated;
    }
    public boolean isUpdated(){
        boolean update;
        UserDAO aUSerDAO = new UserDAOImpl();
        int updateStatus = aUSerDAO.updateUser(this);
        if(updateStatus == 1)
        {
            update = true;
        }
        else{
            System.err.println("Failed to update.");
            update = false;
        }
        return update;
    }
    
    public int testDB() {
        TestDAOImpl x = new TestDAOImpl();
        return x.test();
    }
}
