package com.coreservlets.book.session;

/**
 * A specialization of the CatalogPage servlet that
 * displays a page selling two famous computer books.
 * Orders are sent to the OrderPage servlet.
 * <p/>
 * Taken from Core Servlets and JavaServer Pages 2nd Edition
 * from Prentice Hall and Sun Microsystems Press,
 * http://www.coreservlets.com/.
 * &copy; 2003 Marty Hall; may be freely used or adapted.
 */

public class TechBooksPage extends CatalogPage {
    public void init() {
        String[] ids = {"hall001", "hall002", "hall003"};
        setItems(ids);
        setTitle("All-Time Best Computer Books");
    }
}
