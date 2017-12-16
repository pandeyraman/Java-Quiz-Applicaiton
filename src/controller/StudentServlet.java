package controller;

import domain.Student;
import service.StudentService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by Raman on 2/10/2017.
 */
public class StudentServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = request.getParameter("page");
        UserServlet.checkSession(request, response, page);
        HttpSession session = request.getSession(false);
        if(page.equalsIgnoreCase("studentList")){
            redirectToList(request,response);
        }

        if (page.equalsIgnoreCase("studentForm")) {
            RequestDispatcher rd = request.getRequestDispatcher("student/studentForm.jsp");
            rd.forward(request, response);
        }
        if (page.equalsIgnoreCase("addStudent")) {

            Student student = new Student();
            student.setFirstname(request.getParameter("firstname"));
            student.setLastname(request.getParameter("lastname"));
            student.setRoll(Integer.parseInt(request.getParameter("roll")));

            new StudentService().add(student);

            redirectToList(request, response);
        }
        if(page.equalsIgnoreCase("deleteStudent")){
            int id = Integer.parseInt(request.getParameter("id"));
            new StudentService().delete(id);
            redirectToList(request,response);
        }
        if (page.equalsIgnoreCase("edit")) {
            int id = Integer.parseInt(request.getParameter("id"));
            Student student = new StudentService().getStudent(id);
            request.setAttribute("student", student);

            RequestDispatcher rd = request.getRequestDispatcher("student/editStudent.jsp");
            rd.forward(request, response);
        }
        if (page.equalsIgnoreCase("update")) {

            Student student = new Student();
            student.setFirstname(request.getParameter("firstname"));
            student.setLastname(request.getParameter("lastname"));
            student.setRoll(Integer.parseInt(request.getParameter("roll")));
            student.setId(Integer.parseInt(request.getParameter("id")));

            new StudentService().update(student);
            redirectToList(request, response);
        }

    }
    private void redirectToList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> studentList = new StudentService().getStudentList();
        request.setAttribute("studentList", studentList);

        RequestDispatcher rd = request.getRequestDispatcher("student/studentList.jsp");
        rd.forward(request, response);
    }


    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request,response);
    }
}
