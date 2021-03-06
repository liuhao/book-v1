package com.coreservlets.book;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 * Simple servlet for testing the use of packages
 * and utilities from the same package.
 * <p/>
 * Taken from Core Servlets and JavaServer Pages 2nd Edition
 * from Prentice Hall and Sun Microsystems Press,
 * http://www.coreservlets.com/.
 * &copy; 2003 Marty Hall; may be freely used or adapted.
 */

public class HelloServlet extends HttpServlet {
    private static int stillthere = 1;
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        stillthere += 1;
        PrintWriter out = response.getWriter();
        String title = "Hello (3)";
        out.println(ServletUtilities.headWithTitle(title) +
                "<BODY BGCOLOR=\"#FDF5E6\">\n" +
                "<H1>" + title + "</H1>\n" + stillthere +
                "</BODY></HTML>");
    }
}