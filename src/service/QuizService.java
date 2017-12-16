package service;

import domain.Question;
import domain.Quiz;
import utils.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xmen_alive on 7/24/17.
* */
public class QuizService {

    public void insert(Quiz quiz) {
        String query = "insert into quiz (qid, uid, question,userAns,correct,marks) values(?,?,?,?,?,?)";
        PreparedStatement pstm = new DatabaseConnection().getPreparedStatement(query);
        try {
            pstm.setInt(1, quiz.getqId());
            pstm.setInt(2, quiz.getUid());
            pstm.setString(3, quiz.getQuestion());
            pstm.setString(4, quiz.getClicked());
            pstm.setString(5, quiz.getCorrect());
            pstm.setInt(6, quiz.getMarks());
            System.out.println("Insert");
            pstm.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<Quiz> getQuizList(int uid)
    {
        List<Quiz> quizList = new ArrayList<Quiz>();

        String query = "select * from quiz where uid = ?";

        PreparedStatement pstm = new DatabaseConnection().getPreparedStatement(query);

        String optionCorrect = null, optionUser = null;

        try {
            pstm.setInt(1,uid);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                Quiz quiz = new Quiz();
                quiz.setMarks(rs.getInt("marks"));
                quiz.setqId(rs.getInt("qid"));
                quiz.setUid(rs.getInt("uid"));
                quiz.setClicked(rs.getString("userAns"));
                quiz.setQuestion(rs.getString("question"));
                quiz.setCorrect(rs.getString("correct"));
//                              quizList.add(quiz);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return quizList;
    }

    public int getTotalMarks(int uid)
    {
        String query = "select sum(marks) from quiz where uid = ? ";
        PreparedStatement pstm = new DatabaseConnection().getPreparedStatement(query);
        int totMarks = 0;
        try {
            pstm.setInt(1,uid);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                totMarks = rs.getInt("sum(marks)");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return totMarks;
    }
    public void deleteData()
    {
        String query = "delete from quiz";
        PreparedStatement pstm = new DatabaseConnection().getPreparedStatement(query);
        try {
            pstm.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}




