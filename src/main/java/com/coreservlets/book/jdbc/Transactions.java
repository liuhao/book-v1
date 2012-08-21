package com.coreservlets.book.jdbc;

import java.sql.SQLException;

/**
 * An example to demonstrate submission of a block of
 * SQL statements as a single transaction. Specifically,
 * four new records are inserted into the music table.
 * Performed as a transaction block so that if a problem
 * occurs, a rollback is performed and no changes are
 * committed to the database.
 * <p/>
 * Taken from Core Servlets and JavaServer Pages 2nd Edition
 * from Prentice Hall and Sun Microsystems Press,
 * http://www.coreservlets.com/.
 * &copy; 2003 Marty Hall and Larry Brown.
 * May be freely used or adapted.
 */

public class Transactions {
    public static void main(String[] args) {
        if (args.length < 5) {
            printUsage();
            return;
        }
        String vendor = args[4];
        // Change to DriverUtilities2.loadDrivers() to load
        // vendor drivers from an XML file instead of loading
        // hard-coded vendor drivers in DriverUtilities.
        DriverUtilities.loadDrivers();
        if (!DriverUtilities.isValidVendor(vendor)) {
            printUsage();
            return;
        }
        String driver = DriverUtilities.getDriver(vendor);
        String host = args[0];
        String dbName = args[1];
        String url =
                DriverUtilities.makeURL(host, dbName, vendor);
        String username = args[2];
        String password = args[3];
        doTransactions(driver, url, username, password);
    }

    private static void doTransactions(String driver,
                                       String url,
                                       String username,
                                       String password) {
        String[] transaction =
                {"INSERT INTO music VALUES " +
                        " ( 9, 'Chopin', 'No. 2 in F minor',  100, 17.99)",
                        "INSERT INTO music VALUES " +
                                " (10, 'Tchaikovsky', 'No. 1 in Bb minor', 100, 24.99)",
                        "INSERT INTO music VALUES " +
                                " (11, 'Ravel', 'No. 2 in D major',  100, 14.99)",
                        "INSERT INTO music VALUES " +
                                " (12, 'Schumann', 'No. 1 in A minor',  100, 14.99)"};
        TransactionBean bean = new TransactionBean();
        try {
            bean.setConnection(driver, url, username, password);
            bean.execute(transaction);
        } catch (SQLException sqle) {
            System.err.println("Transaction failure: " + sqle);
        } finally {
            bean.close();
        }
    }

    private static void printUsage() {
        System.out.println("Usage: Transactions host " +
                "dbName username password " +
                "vendor.");
    }
}                                     