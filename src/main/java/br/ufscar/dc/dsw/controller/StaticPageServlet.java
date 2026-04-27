package br.ufscar.dc.dsw.controller;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import jakarta.servlet.*;

import java.io.*;
import java.util.logging.Logger;

@WebServlet(urlPatterns = {"/page", "/p"})
public class StaticPageServlet extends HttpServlet {

    private static Logger logger = Logger.getLogger(StaticPageServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        var target = req.getParameter("target");
        logger.info("GET received for target = " + target);

        if (target == null || target.isBlank()) {
            target = "page_1";
        }

        String path = getServletContext().getRealPath("/pages/" + target + ".html");

        File file = new File(path);

        if (!file.exists()) {
            path = getServletContext().getRealPath("/pages/page_1.html");
        }

        resp.setContentType("text/html;charset=UTF-8");

        try (BufferedReader reader = new BufferedReader(new FileReader(path));
             PrintWriter pw = resp.getWriter()) {

            reader.lines().forEach(pw::println);
        }
    }
}