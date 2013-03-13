package com.cozycoding.crea1;

import javax.swing.*;
import java.awt.*;

/**
 * @author Marius Kristensen
 */
public class Window extends JFrame {

    public Window(String title, Dimension dimension) throws HeadlessException {
        setTitle(title);
        setSize(dimension);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

}
