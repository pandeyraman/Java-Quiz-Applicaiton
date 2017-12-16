package controller;

import domain.Question;

import service.QuestionService;

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
 * Created by Raman on 7/3/2017.
 */
@WebServlet(name = "QuestionsServlet")
public class QuestionsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = request.getParameter("page");
        UserServlet.checkSession(request, response, page);
        HttpSession session = request.getSession(false);

        if (page.equalsIgnoreCase("questionList")) {
            redirectToList(request,response);
        }
        if (page.equalsIgnoreCase("questionForm")) {
            RequestDispatcher rd = request.getRequestDispatcher("question/questionForm.jsp");
            rd.forward(request, response);
        }
        if (page.equalsIgnoreCase("addQuestion")) {
            Question question = new Question();
            question.setQuestion(request.getParameter("question"));
            question.setCategory(request.getParameter("category"));
            question.setOption_1(request.getParameter("option_1"));
            question.setOption_2(request.getParameter("option_2"));
            question.setOption_3(request.getParameter("option_3"));
            question.setOption_4(request.getParameter("option_4"));
            question.setCorrect_ans(request.getParameter("correct_ans"));
            new QuestionService().add(question);
            redirectToList(request, response);

        }
        if (page.equalsIgnoreCase("deleteQuestion")) {
            int id = Integer.parseInt(request.getParameter("id"));
            new QuestionService().delete(id);
            redirectToList(request, response);
        }

        if (page.equalsIgnoreCase("update")) {
            Question question = new Question();
            question.setQuestion(request.getParameter("question"));
            question.setCategory(request.getParameter("category"));
            question.setOption_1(request.getParameter("option_1"));
            question.setOption_2(request.getParameter("option_2"));
            question.setOption_3(request.getParameter("option_3"));
            question.setOption_4(request.getParameter("option_4"));
            question.setCorrect_ans(request.getParameter("correct_ans"));
            question.setId(Integer.parseInt(request.getParameter("id")));
            new QuestionService().update(question);
            redirectToList(request, response);
        }

        if (page.equalsIgnoreCase("editQuestion")) {
            int id = Integer.parseInt(request.getParameter("id"));
            Question question = new QuestionService().getQuestion(id);
            request.setAttribute("question", question);
            RequestDispatcher rd =  request.getRequestDispatcher("question/editQuestion.jsp");
            rd.forward(request, response);
        }

    }
    private void redirectToList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        List<Question> questionList = new QuestionService().getQuestionList();
        request.setAttribute("questionList", questionList);
        RequestDispatcher rd = request.getRequestDispatcher("question/questionList.jsp");
        rd.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);

    }
}
