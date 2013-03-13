package com.cozycoding.crea1;

import javax.swing.*;
import java.awt.*;

/**
 * @author Marius Kristensen
 */
public class Window extends JFrame {

    private Container contentContainer;

    public Window(String title, Dimension dimension) throws HeadlessException {
        super(title);
        setSize(dimension);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        contentContainer = getContentPane();
        contentContainer.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
    }

    public Container getContentContainer() {
        return this.contentContainer;
    }
}
