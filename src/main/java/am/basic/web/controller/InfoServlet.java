package am.basic.web.controller;

import am.basic.web.model.User;
import com.mysql.cj.Session;

import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class InfoServlet extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Cookie[] cookies=request.getCookies();
        for(Cookie cookie:cookies){
            System.out.println(cookie.getName()+" "+cookie.getValue());
        }

        PrintWriter pr1 = response.getWriter();
        pr1.print("<html> <body> <H1> <I>");

        HttpSession ses = request.getSession();
        User user = (User) ses.getAttribute("mek");
        PrintWriter pr = response.getWriter();
        pr.print("name=" + " " + user.getName() + " " + "surname=" + user.getSurname() + " " + "age=" + user.getAge());
        pr1.print("</I> </H1> </body> </HTML>");
    }
}
