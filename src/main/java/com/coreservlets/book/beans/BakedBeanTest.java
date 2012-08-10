package com.coreservlets.book.beans;

/**
 * A small command-line program to test the BakedBean.
 * <p/>
 * Taken from Core Servlets and JavaServer Pages 2nd Edition
 * from Prentice Hall and Sun Microsystems Press,
 * http://www.coreservlets.com/.
 * &copy; 2003 Marty Hall; may be freely used or adapted.
 */

public class BakedBeanTest {
    public static void main(String[] args) {
        BakedBean bean = new BakedBean();
        System.out.println("Original bean: " +
                "level=" + bean.getLevel() +
                ", goesWith=" + bean.getGoesWith());
        if (args.length > 1) {
            bean.setLevel(args[0]);
            bean.setGoesWith(args[1]);
            System.out.println("Updated bean: " +
                    "level=" + bean.getLevel() +
                    ", goesWith=" + bean.getGoesWith());
        }
    }
}
      
