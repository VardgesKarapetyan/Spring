package am.basic.web.controller;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "AuthenticationFilter")
public class AuthenticationFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpSession ses = request.getSession();
        if (ses.getAttribute("mek") == null) {
            HttpServletResponse res = (HttpServletResponse) resp;
            res.sendRedirect("/index.jsp");
        } else {
            chain.doFilter(req, resp);
        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
