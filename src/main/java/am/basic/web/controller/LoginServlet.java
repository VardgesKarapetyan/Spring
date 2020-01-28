package am.basic.web.controller;

import am.basic.web.model.User;
import am.basic.web.repository.UserRepository;
import am.basic.web.repository.UserRepositoryImpl;
import am.basic.web.repository.UserRepositoryImplJdbc;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

public class LoginServlet extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("pass");
        UserRepository userRepositor = new UserRepositoryImpl();
        
        try {
            User user = userRepositor.getbyUsernameAndPassword(username, password);
            if (user != null) {
                //stex
                Cookie cookie=new Cookie("username",user.getUsername());
                cookie.setMaxAge(360000);
                response.addCookie(cookie);
                HttpSession ses=request.getSession();
                ses.setAttribute("mek",user);
                response.sendRedirect("/secure/home.html");
            } else {
                request.setAttribute("abcd","password or username are incorect");
                request.getRequestDispatcher("/index.jsp").forward(request,response);
              /*  PrintWriter pr = response.getWriter();
                pr.print("password or username are incorect");*/
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }


    }

}
