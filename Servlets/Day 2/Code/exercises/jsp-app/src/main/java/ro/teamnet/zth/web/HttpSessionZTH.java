package ro.teamnet.zth.web;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by user on 13.07.2016.
 */
public class HttpSessionZTH extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();

        response.setContentType("text/html");

        if (username.equals("admin") && password.equals("admin")) {

            response.getWriter().write("Welcome back!<br>Username: " + username +
                    "<br>Session ID:" + session.getId());
        } else {

            session.setAttribute("user", username);
            session.setAttribute("session", session);

            response.sendRedirect("views/loginFail.jsp");
        }
    }
}
