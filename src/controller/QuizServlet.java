package controller;

import domain.Question;
import domain.Quiz;
import domain.User;
import service.QuestionService;
import service.QuizService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by xmen_alive on 7/19/17.
 */
@WebServlet(name = "QuizServlet")
public class QuizServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String page = request.getParameter("page");
        UserServlet.checkSession(request, response, page);
        HttpSession session = request.getSession(false);
        User user = (User) session.getAttribute("user");
        Quiz quiz = new Quiz();
        int userId = user.getId();
        if (page.equalsIgnoreCase("quiz")) {
            int id = Integer.parseInt(request.getParameter("id"));
            int marks = 0;
            if (id == 0) {
                getQuestion(request, response, id);
            }else{
                String correct = request.getParameter("correct");
                String  clicked = request.getParameter("option");
                String question = request.getParameter("question");

                if(correct.equalsIgnoreCase(clicked)){
                    quiz.setMarks(10);
                }
                else
                {
                    quiz.setMarks(0);
                }
                quiz.setQuestion(question);
                quiz.setCorrect(correct);

                quiz.setUid((Integer) session.getAttribute("uid"));

                quiz.setqId(id);
                quiz.setClicked(clicked);
                new QuizService().insert(quiz);
                getQuestion(request, response, id);
            }

        }
    }

    private void getQuestion(HttpServletRequest request, HttpServletResponse response, int id) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        Question question = new QuestionService().getRow(id);
        if (question == null) {
            //Display reSult
            List<Quiz> quizList = new QuizService().getQuizList((Integer) session.getAttribute("uid"));
            request.setAttribute("quizResult", quizList);
            int total_marks = new QuizService().getTotalMarks((Integer) session.getAttribute("uid"));
            System.out.println(total_marks);
            request.setAttribute("total_marks",total_marks);
            System.out.println(quizList);
            request.setAttribute("msg", "Final Result");
            List<Question> ques = new QuestionService().getQuestionList();

            request.setAttribute("question", ques) ;
            RequestDispatcher rd = request.getRequestDispatcher("quiz/quizResult.jsp");
            rd.forward(request, response);
        }
        request.setAttribute("question", question);
        RequestDispatcher rd = request.getRequestDispatcher("quiz/playQuiz.jsp");
        rd.forward(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException,IOException {
    doPost(request,response);
}
}