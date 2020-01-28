package am.basic.web.controller;

import am.basic.web.model.User;
import am.basic.web.repository.UserRepository;
import am.basic.web.repository.UserRepositoryImpl;
import am.basic.web.repository.UserRepositoryImplJdbc;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class RegisterServlet extends HttpServlet {
    private   UserRepository userRepositor = new UserRepositoryImpl();
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String username = request.getParameter("username");
        String password = request.getParameter("pass");
        int age=0;
        if(request.getParameter("age")!=null && !(request.getParameter("age").isEmpty())) {
            age = Integer.parseInt(request.getParameter("age"));
        }
        String code = request.getParameter("code");


        try {
            if (name==null || name.isEmpty() || surname == null || surname.isEmpty() || age < 0 || password == null ||password.isEmpty() || username == null ||username.isEmpty() || code == null) {
               // PrintWriter pr = response.getWriter();
               // pr.print("fill all the fields");
                request.setAttribute("abcd","fill all the fields");
                request.getRequestDispatcher("/register.jsp").forward(request,response);
            } else {
                User user = new User();
                user.setName(name);
                user.setAge(age);
                user.setCode(code);
                user.setPassword(password);
                user.setSurname(surname);
                user.setUsername(username);
                userRepositor.savebyUser(user);
                response.sendRedirect("/home.html");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
