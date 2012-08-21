package com.coreservlets.book.jdbc;

import java.sql.*;

/**
 * An example that executes the Oracle stored procedure
 * "discount". Specifically, the price of all compositions
 * by Mozart in the "music" table are discounted by
 * 10 percent.
 * <p/>
 * To create the stored procedure, specify a command-line
 * argument of "create".
 * <p/>
 * Taken from Core Servlets and JavaServer Pages 2nd Edition
 * from Prentice Hall and Sun Microsystems Press,
 * http://www.coreservlets.com/.
 * &copy; 2003 Marty Hall and Larry Brown.
 * May be freely used or adapted.
 */

public class CallableStatements {
    public static void main(String[] args) {
        if (args.length < 5) {
            printUsage();
            return;
        }
        String vendor = args[4];
        // Change to DriverUtilities2.loadDrivers() to force
        // loading of vendor drivers from default XML file.
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

        Connection connection =
                ConnectionInfoBean.getConnection(driver, url,
                        username, password);
        if (connection == null) {
            return;
        }

        try {
            if ((args.length > 5) && (args[5].equals("create"))) {
                createStoredFunction(connection);
            }
            doCallableStatement(connection, "Mozart", 0.10F);
        } catch (SQLException sqle) {
            System.err.println("Problem with callable: " + sqle);
        } finally {
            try {
                connection.close();
            } catch (SQLException sqle) {
                System.err.println("Error closing connection: " + sqle);
            }
        }
    }

    private static void doCallableStatement(Connection connection,
                                            String composer,
                                            float discount)
            throws SQLException {
        CallableStatement statement = null;
        try {
            connection.prepareCall("{ ? = call discount( ?, ? ) }");
            statement.setString(2, composer);
            statement.setFloat(3, discount);
            statement.registerOutParameter(1, Types.INTEGER);
            statement.execute();
            int rows = statement.getInt(1);
            System.out.println("Rows updated: " + rows);
        } catch (SQLException sqle) {
            System.err.println("Problem with callable: " + sqle);
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
    }

    /**
     * Create the Oracle PL/SQL stored procedure "discount".
     * The procedure (technically, a PL/SQL function, since a
     * value is returned), discounts the price for the specified
     * composer in the "music" table.
     */

    private static void createStoredFunction(
            Connection connection)
            throws SQLException {
        String sql = "CREATE OR REPLACE FUNCTION discount " +
                "  (composer_in IN VARCHAR2, " +
                "   discount_in IN NUMBER) " +
                "RETURN NUMBER " +
                "IS " +
                "  min_discount CONSTANT NUMBER:= 0.05; " +
                "  max_discount CONSTANT NUMBER:= 0.50; " +
                "BEGIN " +
                "  IF discount_in BETWEEN min_discount " +
                "                 AND max_discount THEN " +
                "    UPDATE music " +
                "    SET price = price * (1.0 - discount_in) " +
                "    WHERE composer = composer_in; " +
                "    RETURN(SQL%ROWCOUNT); " +
                "  ELSE " +
                "    RETURN(-1); " +
                "  END IF; " +
                "END discount;";
        Statement statement = null;
        try {
            statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException sqle) {
            System.err.println("Problem creating function: " + sqle);
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
    }

    private static void printUsage() {
        System.out.println("Usage: CallableStatement host " +
                "dbName username password " +
                "vendor [create].");
    }
}                       