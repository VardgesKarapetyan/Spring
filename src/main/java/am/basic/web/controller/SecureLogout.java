package am.basic.web.controller;

import javax.servlet.http.*;
import java.io.IOException;

public class SecureLogout extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession ses = request.getSession();
        ses.invalidate();
        Cookie cookie = new Cookie("username", "testttt");
      //  cookie.setMaxAge(0);
       // cookie.setPath("/");
        response.addCookie(cookie);
        response.sendRedirect("/secure/index.jsp");
    }
}
