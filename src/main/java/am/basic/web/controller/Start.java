package am.basic.web.controller;

import am.basic.web.model.User;
import am.basic.web.repository.UserRepository;
import am.basic.web.repository.UserRepositoryImpl;
import am.basic.web.repository.UserRepositoryImplJdbc;

import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

public class Start extends HttpServlet {
  private   UserRepository userRepositor = new UserRepositoryImpl();
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getCookies() == null) {
            response.sendRedirect("/index.jsp");
            return;
        }
        String username = null;

        for (Cookie cookie : request.getCookies()) {
            if (cookie.getName().equals("username")) {
                username = cookie.getValue();
            }
        }
        if (username == null) {
            response.sendRedirect("/index.jsp");
        } else {


            try {
                User user = userRepositor.getbyUsername(username);
                request.getSession().setAttribute("mek", user);
                response.sendRedirect("/secure/home.html");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
