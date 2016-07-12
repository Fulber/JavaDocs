package ro.teamnet.zth.web;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by user on 12.07.2016.
 */
public class InfoHttpServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        StringBuilder htmlTable = new StringBuilder();
        Map<String, String> headerMap = new HashMap<>();
        Enumeration<String> headerNames = req.getHeaderNames();

        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            String headerValue = req.getHeader(headerName);
            headerMap.put(headerName, headerValue);
        }

        htmlTable.append("<table><tr>");
        for (String headerName : headerMap.keySet()) {
            htmlTable.append("<th>" +headerName +"</th>");
        }
        htmlTable.append("</tr>");

        htmlTable.append("<tr>");
        for (String headerName : headerMap.keySet()) {

            htmlTable.append("<td>" +headerMap.get(headerName) +"</td>");
        }
        htmlTable.append("</tr></table>");

        resp.setContentType("text/html");
        resp.getWriter().write(htmlTable.toString());
    }
}
