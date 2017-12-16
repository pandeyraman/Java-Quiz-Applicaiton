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
 * Created by Raman on 7/3/2017.
 */
public class QuestionService {
        public List<Question> getQuestionList() {
        List<Question> questionList = new ArrayList<Question>();
        String query = "select * from question";
        PreparedStatement pstm = new DatabaseConnection().getPreparedStatement(query);
        try {
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Question question = new Question();
                question.setId(rs.getInt("id"));
                question.setQuestion(rs.getString("question"));
                question.setCategory(rs.getString("category"));
                question.setOption_1(rs.getString("option_1"));
                question.setOption_2(rs.getString("option_2"));
                question.setOption_3(rs.getString("option_3"));
                question.setOption_4(rs.getString("option_4"));
                question.setCorrect_ans(rs.getString("correct_ans"));
                questionList.add(question);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return questionList;
    }

    public void add(Question question) {
        String query = "insert into question (question, category, option_1, option_2, option_3, option_4, correct_ans) values(?,?,?,?,?,?,?)";
        PreparedStatement pstm = new DatabaseConnection().getPreparedStatement(query);
        try {
            pstm.setString(1, question.getQuestion());
            pstm.setString(2, question.getCategory());
            pstm.setString(3, question.getOption_1());
            pstm.setString(4, question.getOption_2());
            pstm.setString(5, question.getOption_3());
            pstm.setString(6, question.getOption_4());
            pstm.setString(7, question.getCorrect_ans());
            pstm.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void delete(int id) {
        String query = "delete from question where id=?";
        PreparedStatement pstm = new DatabaseConnection().getPreparedStatement(query);

        try {
            pstm.setInt(1, id);
            pstm.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public Question getRow(int id)
    {
        Question question = null;
        String query = "select * from question where id > ? limit 1";
        PreparedStatement pstm = new DatabaseConnection().getPreparedStatement(query);
        try {
            pstm.setInt(1,id);
            ResultSet rs = pstm.executeQuery();
            while(rs.next())
            {
                question = new Question();
                question.setId(rs.getInt("id"));
                question.setQuestion(rs.getString("question"));
                question.setCategory(rs.getString("category"));
                question.setOption_1(rs.getString("option_1"));
                question.setOption_2(rs.getString("option_2"));
                question.setOption_3(rs.getString("option_3"));
                question.setOption_4(rs.getString("option_4"));
                question.setCorrect_ans(rs.getString("correct_ans"));

//                System.out.println(rs.getString("correctAnswer"));
                System.out.println(question.getQuestion());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return question;
    }
    public Question getQuestion(int id) {
        Question question = null;
        String query = "select * from question where id=?";
        PreparedStatement pstm = new DatabaseConnection().getPreparedStatement(query);
        try {
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                question = new Question();
                question.setId(rs.getInt("id"));
                question.setQuestion(rs.getString("question"));
                question.setCategory(rs.getString("category"));
                question.setOption_1(rs.getString("option_1"));
                question.setOption_2(rs.getString("option_2"));
                question.setOption_3(rs.getString("option_3"));
                question.setOption_4(rs.getString("option_4"));
                question.setCorrect_ans(rs.getString("correct_ans"));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return question;
    }

    public void update(Question question) {
            String query = "UPDATE `question` SET `question`=?,`category`=?,`option_1`=?,`option_2`=?,`option_3`=?,`option_4`=?,`correct_ans`=? WHERE `id`=?";
        PreparedStatement pstm = new DatabaseConnection().getPreparedStatement(query);

        try {
            pstm.setString(1, question.getQuestion());
            pstm.setString(2, question.getCategory());
            pstm.setString(3, question.getOption_1());
            pstm.setString(4, question.getOption_2());
            pstm.setString(5, question.getOption_3());
            pstm.setString(6, question.getOption_4());
            pstm.setString(7, question.getCorrect_ans());
            pstm.setInt(8, question.getId());

            pstm.execute();

            System.out.println(question.getId());
            System.out.println(question.getQuestion());
            System.out.println(question.getCategory());
            System.out.println(question.getOption_1());
            System.out.println(question.getOption_2());
            System.out.println(question.getOption_3());
            System.out.println(question.getOption_4());
            System.out.println(question.getCorrect_ans());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
