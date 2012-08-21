package com.coreservlets.book.jdo;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Populate database with music records by using JDO.
 * <p/>
 * Taken from Core Servlets and JavaServer Pages 2nd Edition
 * from Prentice Hall and Sun Microsystems Press,
 * http://www.coreservlets.com/.
 * &copy; 2003 Marty Hall and Larry Brown.
 * May be freely used or adapted.
 */

public class PopulateMusicTable {
    public static void main(String[] args) {
        // Create seven new music objects to place in the database.
        Music[] objects = {
                new Music(1, "Mozart", "No. 21 in C# minor", 7, 24.99F),
                new Music(2, "Beethoven", "No. 3 in C minor", 28, 10.99F),
                new Music(3, "Beethoven", "No. 5 Eb major", 33, 10.99F),
                new Music(4, "Rachmaninov", "No. 2 in C minor", 9, 18.99F),
                new Music(5, "Mozart", "No. 24 in C minor", 11, 21.99F),
                new Music(6, "Beethoven", "No. 4 in G", 33, 12.99F),
                new Music(7, "Liszt", "No. 1 in Eb major", 48, 10.99F)
        };

        // Load properties file with JDO information. The properties
        // file contains ORM Framework information specific to the
        // vendor and information for connecting to the database.
        Properties properties = new Properties();
        try {
            FileInputStream fis =
                    new FileInputStream("jdo.properties");
            properties.load(fis);
        } catch (IOException ioe) {
            System.err.println("Problem loading properties file: " +
                    ioe);
            return;
        }

        // Initialize manager for persistence framework.
        PersistenceManagerFactory pmf =
                JDOHelper.getPersistenceManagerFactory(properties);
        PersistenceManager pm = pmf.getPersistenceManager();

        // Write the new Music objects to the database.
        Transaction transaction = pm.currentTransaction();
        transaction.begin();
        pm.makePersistentAll(objects);
        transaction.commit();
        pm.close();
    }
}    