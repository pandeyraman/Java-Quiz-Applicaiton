package controller;

import domain.User;
import service.QuizService;
import service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by Raman on 2/25/2017.
 */
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = request.getParameter("page");
        if (page.equalsIgnoreCase("login")) {

            String name = request.getParameter("username");
            String password = request.getParameter("password");

            User user = new UserService().getUser(name, password);

            if (user != null) {
                HttpSession session = request.getSession(false);
                session.setAttribute("user",user);
                session.setAttribute("uid", user.getId());
                QuizService quizService = new QuizService();

                quizService.deleteData();
                RequestDispatcher rd = request.getRequestDispatcher("user/home.jsp");
                rd.forward(request, response);
            } else {
                HttpSession session = request.getSession(false);
                session.setAttribute("user",user);
                System.out.println("Error in login");
                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                rd.forward(request, response);
            }
        }
        if(!page.equalsIgnoreCase("login")&&!page.equalsIgnoreCase("logout"))
        {
            HttpSession session = request.getSession(false);
            User user =(User) session.getAttribute("user");
            if (user == null){
                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                rd.forward(request,response);
            }
        }
        if(page.equalsIgnoreCase("logout")){
            HttpSession session = request.getSession(false);
            session.invalidate();
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
        }
        if(page.equalsIgnoreCase("home")){
            RequestDispatcher rd = request.getRequestDispatcher("user/home.jsp");
            rd.forward(request, response);
        }
        if(page.equalsIgnoreCase("userList")){
            redirectToList(request,response);
        }

        if(page.equalsIgnoreCase("userForm")){
            RequestDispatcher rd = request.getRequestDispatcher("user/userForm.jsp");
            rd.forward(request,response);
        }
        if(page.equalsIgnoreCase("userList")){
            redirectToList(request,response);
        }
        if(page.equalsIgnoreCase("addUser")){
            User user = new User();
            user.setUsername(request.getParameter("username"));
            user.setPassword(request.getParameter("password"));
            user.setRole(request.getParameter("role"));
            new UserService().insert(user);

            redirectToList(request, response);
        }
        if(page.equalsIgnoreCase("deleteUser")){
            int id = Integer.parseInt(request.getParameter("id"));
            new UserService().delete(id);
            redirectToList(request,response);
        }
        if (page.equalsIgnoreCase("edit")) {
            int id = Integer.parseInt(request.getParameter("id"));
            User user = new UserService().getUser(id);
            request.setAttribute("user", user);

            RequestDispatcher rd = request.getRequestDispatcher("user/editUser.jsp");
            rd.forward(request, response);
        }
        if (page.equalsIgnoreCase("update")) {

            User user = new User();
            user.setUsername(request.getParameter("username"));
            user.setPassword(request.getParameter("password"));
            user.setRole(request.getParameter("role"));
            user.setId(Integer.parseInt(request.getParameter("id")));

            new UserService().update(user);

            redirectToList(request, response);
        }

    }

    private void redirectToList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> userList = new UserService().getUserList();
        request.setAttribute("userList", userList);

        RequestDispatcher rd = request.getRequestDispatcher("user/userList.jsp");
        rd.forward(request, response);
    }
    public static void checkSession(HttpServletRequest request, HttpServletResponse response, String page){
        if(page==null){
            page = "xyz";
        }
        if(!page.equalsIgnoreCase("login")){
            HttpSession session = request.getSession(false);
            User user = (User) session.getAttribute("user");
            if(user==null){
                String message = "Login First !!!";
                try {
                    request.setAttribute("msg",message);
                    request.getRequestDispatcher("index.jsp").forward(request,response);
                } catch (ServletException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
