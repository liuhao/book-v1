package PluginApplet;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * JPanel that places a panel with text drawn at various angles
 * in the top part of the window and a JComboBox containing
 * font choices in the bottom part.
 * <p/>
 * Taken from Core Servlets and JavaServer Pages 2nd Edition
 * from Prentice Hall and Sun Microsystems Press,
 * http://www.coreservlets.com/.
 * &copy; 2003 Marty Hall; may be freely used or adapted.
 */

public class TextPanel extends JPanel
        implements ActionListener {
    private JComboBox fontBox;
    private DrawingPanel drawingPanel;

    public TextPanel() {
        GraphicsEnvironment env =
                GraphicsEnvironment.getLocalGraphicsEnvironment();
        String[] fontNames = env.getAvailableFontFamilyNames();
        fontBox = new JComboBox(fontNames);
        setLayout(new BorderLayout());
        JPanel fontPanel = new JPanel();
        fontPanel.add(new JLabel("Font:"));
        fontPanel.add(fontBox);
        JButton drawButton = new JButton("Draw");
        drawButton.addActionListener(this);
        fontPanel.add(drawButton);
        add(fontPanel, BorderLayout.SOUTH);
        drawingPanel = new DrawingPanel();
        fontBox.setSelectedItem("Serif");
        drawingPanel.setFontName("Serif");
        add(drawingPanel, BorderLayout.CENTER);
    }

    public void actionPerformed(ActionEvent e) {
        drawingPanel.setFontName((String) fontBox.getSelectedItem());
        drawingPanel.repaint();
    }
}
