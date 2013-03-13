package com.cozycoding.crea1;

import java.awt.*;

/**
 * Hello world!
 *
 */
public class App 
{
    private static final int windowWidth = 320;
    private static final int windowHeight = 240;
    private static final String title = "#1 Window - Cozy Coding";

    public static void main(String[] args) {
        Window window = new Window(title, new Dimension(windowWidth, windowHeight));
        final TetrisPanel tetrisPanel = new TetrisPanel(new Dimension(windowWidth, windowHeight));
        window.getContentContainer().add(tetrisPanel);
    }
}
