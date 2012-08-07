package com.coreservlets.book; // Always use packages!!

/**
 * Simple utility to generate random integers.
 * <p/>
 * Taken from Core Servlets and JavaServer Pages 2nd Edition
 * from Prentice Hall and Sun Microsystems Press,
 * http://www.coreservlets.com/.
 * &copy; 2003 Marty Hall; may be freely used or adapted.
 */

public class RanUtilities {

    /**
     * A random int from 1 to range (inclusive).
     */

    public static int randomInt(int range) {
        return (1 + ((int) (Math.random() * range)));
    }

    /**
     * Test routine. Invoke from the command line with
     * the desired range. Will print 100 values.
     * Verify that you see values from 1 to range (inclusive)
     * and no values outside of that interval.
     */

    public static void main(String[] args) {
        int range = 10;
        try {
            range = Integer.parseInt(args[0]);
        } catch (Exception e) { // Array index or number format
            // Do nothing: range already has default value.
        }
        for (int i = 0; i < 100; i++) {
            System.out.println(randomInt(range));
        }
    }
}
