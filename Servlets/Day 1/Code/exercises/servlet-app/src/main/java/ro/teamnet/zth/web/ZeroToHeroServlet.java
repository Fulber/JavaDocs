package ro.teamnet.zth.web;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by user on 12.07.2016.
 */
public class ZeroToHeroServlet extends HttpServlet {

    private String handleRequest(HttpServletRequest req) {

        String response = "Hello <b>" + req.getParameter("firstName") + " " +
                req.getParameter("lastName") + "</b>! Enjoy Zero To Hero!!!";

        return response;
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        resp.setContentType("text/html");
        resp.getWriter().write(handleRequest(req));
    }
}
