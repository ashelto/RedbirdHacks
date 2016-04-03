package controller;

import dao.QuizDAO;
import dao.QuizDAOImpl;
import java.util.ArrayList;
import java.util.Random;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;
import model.Answer;
import model.Question;
import model.Quiz;

/**
 *
 * @author it3530117
 */
@ManagedBean
@SessionScoped
public class TakeQuizController implements ActionListener{

    /**
     * Creates a new instance of TakeQuizController
     */
    Quiz quizModel;
    String userResponse;
    int index = 0;
    private String buttonId;
    String output;

    public TakeQuizController() {
        quizModel = new Quiz();
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Quiz getQuizModel() {
        return quizModel;
    }

    public void setQuizModel(Quiz quizModel) {
        this.quizModel = quizModel;
    }

    public String getButtonId() {
        return buttonId;
    }

    public void setButtonId(String buttonId) {
        this.buttonId = buttonId;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public String getUserResponse() {
        return userResponse;
    }

    public void setUserResponse(String userResponse) {
        this.userResponse = userResponse;
    }

    public void prerenderSetup() {
        QuizDAO quizDAO = new QuizDAOImpl();
        quizModel = quizDAO.getQuizByID(quizModel.getQuizId());
    }

    public String launchQuiz() {
        String questionType = quizModel.getQuestionSet().get(index).getQuestionType();
        if (questionType.equals("MC")) {
            return "/multipleChoiceView.xhtml";
        } else if (questionType.equals("TF")) {
            return "/trueFalseView.xhtml";
        } else if (questionType.equals("FITB")) {
            return "fillinTheBlankView.xhtml";
        } else {
            System.out.println("ERROR: launchQuiz");
        }
        return "";
    }

    public Question getQuestion(int index) {
        Question question = quizModel.getQuestionSet().get(index);
        return question;
    }
    /* getters and setters for buttonId goes here */

   
    public int generateIndex() {
        Random rand = new Random();
        int index = rand.nextInt(2) + 0;
        return index;
    }
    public boolean evaluateAnswer(int choice)
    {
         boolean correct = false;
           ArrayList<Answer> temp = quizModel.getQuestionSet().get(index).getAnswers();
              if(temp.get(choice).isCorrect())
              {
                  correct = true;
                  output = "You answered correctly!";
              }
              else
              {
                  output = "You answered incorrectly.";
              }
           
        return correct;
    }

    @Override
    public void processAction(ActionEvent event) throws AbortProcessingException {
        /* retrieve buttonId which you clicked */
//        buttonId = event.getComponent().getId();
//        Question currentQ = quizModel.getQuestionSet().get(index);
//        /*check for which button you clicked*/
//        if (currentQ.getQuestionType().equals("MC")) {
//            if (buttonId.equals("ans1")) {
//                setUserResponse(quizModel.getQuestionSet().get(index).getAnswers().get(0).toString());
//            } else if (buttonId.equals("ans2")) {
//                setUserResponse(quizModel.getQuestionSet().get(index).getAnswers().get(1).toString());
//            } else if (buttonId.equals("ans3")) {
//                setUserResponse(quizModel.getQuestionSet().get(index).getAnswers().get(2).toString());
//            } else if (buttonId.equals("ans4")) {
//                setUserResponse(quizModel.getQuestionSet().get(index).getAnswers().get(3).toString());
//            }
//        } else if (currentQ.getQuestionType().equals("TF")) {
//            if (buttonId.equals("ans1")) {
//                setUserResponse(quizModel.getQuestionSet().get(index).getAnswers().get(0).toString());
//            } else if (buttonId.equals("ans2")) {
//                setUserResponse(quizModel.getQuestionSet().get(index).getAnswers().get(1).toString());
//            } else if (currentQ.getQuestionType().equals("FITB")) {
//                if (buttonId.equals("ans1")) {
//                    setUserResponse(quizModel.getQuestionSet().get(index).getAnswers().get(0).toString());
//                }
//            }
//        }
 
 
        UIComponent ui = event.getComponent();
        System.out.println("Event source is" + ui.getClass().getName());
 
    }

    
}