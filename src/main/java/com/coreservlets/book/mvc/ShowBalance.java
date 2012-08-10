package com.coreservlets.book.mvc;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet that reads a customer ID and displays
 * information on the account balance of the customer
 * who has that ID.
 * <p/>
 * Taken from Core Servlets and JavaServer Pages 2nd Edition
 * from Prentice Hall and Sun Microsystems Press,
 * http://www.coreservlets.com/.
 * &copy; 2003 Marty Hall; may be freely used or adapted.
 */

public class ShowBalance extends HttpServlet {
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
        BankCustomer customer =
                BankCustomer.getCustomer(request.getParameter("id"));
        String address;
        if (customer == null) {
            address = "/WEB-INF/mvc/UnknownCustomer.jsp";
        } else if (customer.getBalance() < 0) {
            address = "/WEB-INF/mvc/NegativeBalance.jsp";
            request.setAttribute("badCustomer", customer);
        } else if (customer.getBalance() < 10000) {
            address = "/WEB-INF/mvc/NormalBalance.jsp";
            request.setAttribute("regularCustomer", customer);
        } else {
            address = "/WEB-INF/mvc/HighBalance.jsp";
            request.setAttribute("eliteCustomer", customer);
        }
        RequestDispatcher dispatcher =
                request.getRequestDispatcher(address);
        dispatcher.forward(request, response);
    }
}
