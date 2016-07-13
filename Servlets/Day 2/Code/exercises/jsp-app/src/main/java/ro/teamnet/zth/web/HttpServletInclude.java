package ro.teamnet.zth.web;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by user on 13.07.2016.
 */
public class HttpServletInclude extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        response.getWriter().write("Hello from HttpServletInclude");

        request.setAttribute("testAttribute", "Enjoy Z2H");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/httpincluded");
        requestDispatcher.include(request, response);
    }
}
