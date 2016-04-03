package dao;
import model.Question;

public interface QuestionDAO {
    
    public int createQuestion(Question aQuestion, int quizId);
//    public Question findQuestion(Question aQuestion); 
//    public int updateQuestion(Question aQuestion);
}