/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.Question;
import model.User;

/**
 *
 * @author it3530218
 */
@ManagedBean
@SessionScoped
public class questionController 
{
    private User theModel;
    private Question question;
    private String response = "";
    private String[] type = {"Select Question", "Multiple Choice","True/False","Fill in the blank"};
    private String renderMC = "false";
    private String renderFill = "false";
    private String renderTF = "false";
    private String renderShort = "false";
    

    public questionController() {
          question = new Question();
    }

    
    
    /**
     * @return the theModel
     */
    public User getTheModel() {
        return theModel;
    }

    /**
     * @param theModel the theModel to set
     */
    public void setTheModel(User theModel) {
        this.theModel = theModel;
    }

    /**
     * @return the question
     */
    public Question getQuestion() {
        return question;
    }

    /**
     * @param question the question to set
     */
    public void setQuestion(Question question) {
        this.question = question;
    }

    /**
     * @return the type
     */
    public String[] getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String[] type) {
        this.type = type;
    }
    
    
    
    public String testMyApp()
    {
        String temppppp = "ffffff";
       if(question.getQuestionType() != null)
       {
           response = question.getQuestionType();
           return "createQuestion.xhtml";
       }
       else
       {
           response = "failed";
           return "createQuestion.xhtml";
       }
    }

    /**
     * @return the response
     */
    public String getResponse() {
        return response;
    }

    /**
     * @param response the response to set
     */
    public void setResponse(String response) {
        this.response = response;
    }

    /**
     * @return the renderMC
     */
    public String getRenderMC() {
        return renderMC;
    }

    /**
     * @param renderMC the renderMC to set
     */
    public void setRenderMC(String renderMC) {
        this.renderMC = renderMC;
    }

    /**
     * @return the renderFill
     */
    public String getRenderFill() {
        return renderFill;
    }

    /**
     * @param renderFill the renderFill to set
     */
    public void setRenderFill(String renderFill) {
        this.renderFill = renderFill;
    }

    /**
     * @return the renderTF
     */
    public String getRenderTF() {
        return renderTF;
    }

    /**
     * @param renderTF the renderTF to set
     */
    public void setRenderTF(String renderTF) {
        this.renderTF = renderTF;
    }

    /**
     * @return the renderShort
     */
    public String getRenderShort() {
        return renderShort;
    }

    /**
     * @param renderShort the renderShort to set
     */
    public void setRenderShort(String renderShort) {
        this.renderShort = renderShort;
    }
    
    public String render()
    {
        String render = "";
        if(question.getQuestionType() != null)
        {
            render = question.getQuestionType();
        }
        else
        {
            render = "Select Question";
        }
        if(render.equals("Select Question"))
        {
            response = "please select a question type";
            renderMC = "false";
            renderTF = "false";
            renderFill = "false";
            renderShort = "false";
            return "createQuestion.xhtml";
        }
        if(render.equals("Multiple Choice"))
        {
            response = "";
            renderMC = "true";
            renderTF = "false";
            renderFill = "false";
            renderShort = "false";
            return "createQuestion.xhtml";
        }
        if(render.equals("True/False"))
        {
            response = "";
            renderMC = "false";
            renderTF = "true";
            renderFill = "false";
            renderShort = "false";
            return "createQuestion.xhtml";
        }
        if(render.equals("Fill in the blank"))
        {
            
            response = "";
            renderMC = "false";
            renderTF = "false";
            renderFill = "true";
            renderShort = "false";
            return "createQuestion.xhtml";
        }
        if(render.equals("Short Answer"))
        {
            response = "";
            renderMC = "false";
            renderTF = "false";
            renderFill = "false";
            renderShort = "true";
            return "createQuestion.xhtml";
        }
        return "createQuestion.xhtml";
    }


    
    
    
}
