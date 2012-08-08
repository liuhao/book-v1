package PluginApplet;

import javax.swing.*;

/**
 * An applet that uses Swing and Java 2D and thus requires
 * the Java Plug-In.
 * <p/>
 * Taken from Core Servlets and JavaServer Pages 2nd Edition
 * from Prentice Hall and Sun Microsystems Press,
 * http://www.coreservlets.com/.
 * &copy; 2003 Marty Hall; may be freely used or adapted.
 */

public class PluginApplet extends JApplet {
    public void init() {
        WindowUtilities.setNativeLookAndFeel();
        setContentPane(new TextPanel());
    }
}
