package com.coreservlets.book.jdbc;

import java.sql.*;

/**
 * An example to test the timing differences resulting
 * from repeated raw queries vs. repeated calls to
 * prepared statements. These results will vary dramatically
 * among database servers and drivers. With our setup
 * and drivers, Oracle9i prepared statements took only 62% of
 * the time that raw queries required, whereas MySQL
 * prepared statements took nearly the same time as
 * raw queries, with only an 8% improvement.
 * <p/>
 * Taken from Core Servlets and JavaServer Pages 2nd Edition
 * from Prentice Hall and Sun Microsystems Press,
 * http://www.coreservlets.com/.
 * &copy; 2003 Marty Hall and Larry Brown.
 * May be freely used or adapted.
 */

public class PreparedStatements {
    public static void main(String[] args) {
        if (args.length < 5) {
            printUsage();
            return;
        }
        String vendor = args[4];
        // Use DriverUtilities2.loadDrivers() to load
        // the drivers from an XML file.
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
        // Use "print" only to confirm it works properly,
        // not when getting timing results.
        boolean print = false;
        if ((args.length > 5) && (args[5].equals("print"))) {
            print = true;
        }
        Connection connection =
                ConnectionInfoBean.getConnection(driver, url,
                        username, password);
        if (connection != null) {
            doPreparedStatements(connection, print);
            doRawQueries(connection, print);
        }
        try {
            connection.close();
        } catch (SQLException sqle) {
            System.err.println("Problem closing connection: " + sqle);
        }
    }

    private static void doPreparedStatements(Connection conn,
                                             boolean print) {
        try {
            String queryFormat =
                    "SELECT id FROM music WHERE price < ?";
            PreparedStatement statement =
                    conn.prepareStatement(queryFormat);
            long startTime = System.currentTimeMillis();
            for (int i = 0; i < 100; i++) {
                statement.setFloat(1, i / 4);
                ResultSet results = statement.executeQuery();
                if (print) {
                    showResults(results);
                }
            }
            long stopTime = System.currentTimeMillis();
            double elapsedTime = (stopTime - startTime) / 1000.0;
            System.out.println("Executing prepared statement " +
                    "100 times took " +
                    elapsedTime + " seconds.");
        } catch (SQLException sqle) {
            System.err.println("Error executing statement: " + sqle);
        }
    }

    public static void doRawQueries(Connection conn,
                                    boolean print) {
        try {
            String queryFormat =
                    "SELECT id FROM music WHERE price < ";
            Statement statement = conn.createStatement();
            long startTime = System.currentTimeMillis();
            for (int i = 0; i < 100; i++) {
                ResultSet results =
                        statement.executeQuery(queryFormat + i / 4);
                if (print) {
                    showResults(results);
                }
            }
            long stopTime = System.currentTimeMillis();
            double elapsedTime = (stopTime - startTime) / 1000.0;
            System.out.println("Executing raw query " +
                    "100 times took " +
                    elapsedTime + " seconds.");
        } catch (SQLException sqle) {
            System.err.println("Error executing query: " + sqle);
        }
    }

    private static void showResults(ResultSet results)
            throws SQLException {
        while (results.next()) {
            System.out.print(results.getString(1) + " ");
        }
        System.out.println();
    }

    private static void printUsage() {
        System.out.println("Usage: PreparedStatements host " +
                "dbName username password " +
                "vendor [print].");
    }
}          