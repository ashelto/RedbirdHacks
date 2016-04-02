/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.UserDAO;
import dao.UserDAOImpl;
import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.servlet.http.HttpServletResponse;
import model.User;

/**
 *
 * @author billylim
 */
@ManagedBean
@SessionScoped
public class LoginController {

    private boolean loggedIn = false;
    User theModel;
    String response;
    String oldPw;
    String newPw;
    private String confirmPassword;
    private String[] roles = {"Student", "Professor"};

    String role = ""; // = "admin";
    private int attempts = 0;

    public String[] getRoles() {
        return roles;
    }

    public void setRoles(String[] roles) {
        this.roles = roles;
    }

    public User getTheModel() {
        return theModel;
    }

    public void setTheModel(User theModel) {
        this.theModel = theModel;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public LoginController() {
        theModel = new User();
    }

    public String getOldPw() {
        return oldPw;
    }

    public void setOldPw(String oldPw) {
        this.oldPw = oldPw;
    }

    public String getNewPw() {
        return newPw;
    }

    public void setNewPw(String newPw) {
        this.newPw = newPw;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public int getAttempts() {
        return attempts;
    }

    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void checkIfLoggedIn() {
        if (!loggedIn) {
            // Can't just return "login" as it not an "action" event (// Ref: http://stackoverflow.com/questions/16106418/how-to-perform-navigation-in-prerenderview-listener-method)
            FacesContext fc = FacesContext.getCurrentInstance();
            ConfigurableNavigationHandler nav = (ConfigurableNavigationHandler) fc.getApplication().getNavigationHandler();
            nav.performNavigation("login?faces-redirect=true");
        }
    }

    public String processLogin() {
        setRole("admin");
        if (attemptsLeft()) {
            if (!theModel.isValidUser()) {
                loggedIn = false;
                response = "Invalid username/password!";
                setAttempts(getAttempts() + 1);
                return ""; // stay right at the current page
            } else {
                loggedIn = true;
                response = "";
                if (theModel.getRole().equals("Student")) {
                    return "response.xhtml";
                } else if (theModel.getRole().equals("Professor")) {
                    return "profView.xhtml";
                }
            }
        } else {
            return "";
        }
        return "";
    }

    public String processSignup() {
        if (!theModel.getPassword().equals(confirmPassword)) {
            response = "Your passwords do not match.";
        } else {
            if (theModel.isValidUser()) {
                loggedIn = false;
                response = "Username is taken";
                return ""; // stay right at the current page
            } else {
                loggedIn = true;
                role = "admin";
                response = "";
                UserDAOImpl impl = new UserDAOImpl();
                if (impl.createUser(theModel) == 1) {
                    if (theModel.getRole().equals("Student")) {
                        return "response.xhtml";
                    } else if (theModel.getRole().equals("Professor")) {
                        return "profView.xhtml";
                    }
                } else {
                    response = "insert user failed.";
                    return "";
                }
            }
        }
        return "";
    }

    public boolean attemptsLeft() {

        if (getAttempts() >= 3) {
            response = "you have exhausted your attempts to login.";
            return false;
        } else {
            return true;
        }
    }

    public String logout() {
        loggedIn = false;
        theModel.setUsername("");
        theModel.setPassword("");
        return "index.xhtml";

    }

    public String executeUpdate() {
        if (theModel.getPassword().equals(oldPw)) {
            if (!newPw.equals("")) {
                role = "admin";
                theModel.setPassword(newPw);
            }
        }
        if (theModel.isUpdated()) {
//            UpdateEmail ue = new UpdateEmail();
//            ue.sendEmail(theModel.getEmail(), "jpopile@ilstu.edu");
            return "response.xhtml";
        } else {
            return "index.xhtml";
        }
    }

    public String isAdmin(ComponentSystemEvent event) {
        String navi = null;

        if (!role.equals("admin")) {
            FacesContext fc = FacesContext.getCurrentInstance();
            ConfigurableNavigationHandler nav = (ConfigurableNavigationHandler) fc.getApplication().getNavigationHandler();
            nav.performNavigation("access-denied?faces-redirect=true");
        }
        return navi;
    }

    //String username, String firstName, String lastName, String password, String email, int role
    public void createFakeUser() {
        User fakeUser = new User("Admin", "Joe", "Momma", "password", "email@mail.com", "adminrole");
        UserDAO aUserDAO = new UserDAOImpl();
        aUserDAO.createUser(fakeUser);
    }
}
