package com.coreservlets.book.cookie;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 * Reads firstName and lastName request parameters and forwards
 * to JSP page to display them. Uses session-based bean sharing
 * to remember previous values.
 */

public class RegistrationServlet extends HttpServlet {
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        boolean isMissingValue = false;
        String firstName = request.getParameter("firstName");
        if (isMissing(firstName)) {
            firstName = "Missing first name";
            isMissingValue = true;
        }
        String lastName = request.getParameter("lastName");
        if (isMissing(lastName)) {
            lastName = "Missing last name";
            isMissingValue = true;
        }
        String emailAddress = request.getParameter("emailAddress");
        if (isMissing(emailAddress)) {
            emailAddress = "Missing email address";
            isMissingValue = true;
        }
        Cookie c1 = new LongLivedCookie("firstName", firstName);
        response.addCookie(c1);
        Cookie c2 = new LongLivedCookie("lastName", lastName);
        response.addCookie(c2);
        Cookie c3 = new LongLivedCookie("emailAddress",
                emailAddress);
        response.addCookie(c3);
        String formAddress =
                "/RegistrationForm";
        if (isMissingValue) {
            response.sendRedirect(formAddress);
        } else {
            PrintWriter out = response.getWriter();
            String docType =
                    "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
                            "Transitional//EN\">\n";
            String title = "Thanks for Registering";
            out.println
                    (docType +
                            "<HTML>\n" +
                            "<HEAD><TITLE>" + title + "</TITLE></HEAD>\n" +
                            "<BODY BGCOLOR=\"#FDF5E6\">\n" +
                            "<CENTER>\n" +
                            "<H1 ALIGN>" + title + "</H1>\n" +
                            "<UL>\n" +
                            " <LI><B>First Name</B>: " +
                            firstName + "\n" +
                            " <LI><B>Last Name</B>: " +
                            lastName + "\n" +
                            " <LI><B>Email address</B>: " +
                            emailAddress + "\n" +
                            "</UL>\n" +
                            "</CENTER></BODY></HTML>");
        }
    }

    /**
     * Determines if value is null or empty.
     */
    private boolean isMissing(String param) {
        return ((param == null) ||
                (param.trim().equals("")));
    }
}
